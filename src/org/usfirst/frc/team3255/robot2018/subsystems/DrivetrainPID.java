package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DrivetrainPID extends PIDSubsystem {
	
	double output = 0.0;
	boolean outputValid = false;
	double tolerance = 0.0;
	int targetcounter = 0;

    // Initialize your subsystem here
    public DrivetrainPID() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(0, 0, 0);
    	this.setSetpoint(0.0);
    	
    }
    
    public void enable(double maxspeed) {
    	this.getPIDController().setPID(
    		RobotPreferences.drivetrainP(),
    		RobotPreferences.drivetrainI(),
    		RobotPreferences.drivetrainD());
 
    	outputValid = false;
    	
    	super.enable();
    		
    }
    
    public void enable() {
    	enable(RobotPreferences.drivetrainMaxSpeed());
    }
    

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
