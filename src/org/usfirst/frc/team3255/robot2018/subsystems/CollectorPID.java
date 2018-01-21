package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class CollectorPID extends PIDSubsystem {
	
	double output = 0.0;
	boolean outputValid = false;
	double tolerance = 0.0;
	int targetCounter = 0;

    // Initialize your subsystem here
    public CollectorPID() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(0, 0, 0);
    	this.setSetpoint(0.0);
    }
    
    public void enable(double maxSpeed) {
    	this.getPIDController().setPID(
    			RobotPreferences.collectorP(),
    			RobotPreferences.collectorI(),
    			RobotPreferences.collectorD());
    	
    	outputValid = false;
    	
    	super.enable();
    }
    
    public void enable() {
    	enable(RobotPreferences.collectorMaxSpeed());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return Robot.collector.getEncoderCount();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	this.output = output;
    	outputValid = true;
    }
    
    public double getOutput() {
    	if((this.getPIDController().isEnabled() == false) || (outputValid == false)) {
    		return 0.0;
    	}
    	
    	return output;
    }
    
    public void setRawTolerance(double tolerance) {
    	this.tolerance = tolerance;
    }
    
    public boolean onRawTarget() {
    	if (Math.abs(getPIDController().getSetpoint() - Robot.collector.getEncoderCount()) < tolerance) {
    		targetCounter = targetCounter +1;
    	}
    	else {
    		targetCounter = 0;
    	}
    	
    	return (targetCounter >= RobotPreferences.collectorTargetCount());
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
