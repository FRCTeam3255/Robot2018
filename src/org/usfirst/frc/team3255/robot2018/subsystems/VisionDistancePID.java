package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class VisionDistancePID extends PIDSubsystem {
	
	boolean outputValid = false;
	double tolerance = 0.0;
	int targetCounter = 0;
	double output = 0.0;
	
    // Initialize your subsystem here
    public VisionDistancePID() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(0, 0, 0);
    	this.setSetpoint(0.0);
    }
    
    public void enable(double maxspeed) {
    	this.getPIDController().setPID(
    	RobotPreferences.visionDistanceP(),
    	RobotPreferences.visionDistanceI(),
    	RobotPreferences.visionDistanceD());
    
    	this.setOutputRange(-maxspeed, maxspeed);
    
    	outputValid =  false;
    
    	super.enable();
    }
    
    public void enable() {
    	enable(RobotPreferences.drivetrainMaxSpeed());
    }
    
    protected double returnPIDInput() {
        return Robot.navigation.getTargetDistance();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	this.output = output;
    	outputValid = Robot.navigation.isTargetFound();
    }
    //Use the output when the PID is running and output 
    public double getOutput() {
    	if((this.getPIDController().isEnabled() == false || (outputValid == false))) {
    		return 0.0;
    	}
    	
    	return output;
    }
    
    public void setRawTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
    
    public boolean onRawTarget() {
    	if (Math.abs(getPIDController().getSetpoint() - Robot.navigation.getTargetDistance()) < tolerance) {
    		targetCounter = targetCounter + 1;
    	}
    	else {
    		targetCounter = 0;
    	}
    	
    	return (targetCounter >= RobotPreferences.visionTargetCount());
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
