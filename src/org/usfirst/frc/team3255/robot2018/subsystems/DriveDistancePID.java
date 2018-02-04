package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public abstract class DriveDistancePID extends PIDSubsystem {
	
	protected double output = 0.0;
	protected boolean outputValid = false;
	protected double tolerance = 0.0;
	protected int targetCounter = 0;
	
	protected double minPIDSpeed = 0;
	protected double maxPIDSpeed = 1;

    // Initialize your subsystem here
    public DriveDistancePID() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(0, 0, 0);
    	this.setSetpoint(0.0);
    }
    
    public void enable() {
    	this.getPIDController().setPID(
    		RobotPreferences.drivetrainP(),
    		RobotPreferences.drivetrainI(),
    		RobotPreferences.drivetrainD());
    	
    	minPIDSpeed = RobotPreferences.distancePIDMin();
    	maxPIDSpeed = RobotPreferences.distancePIDMax();
 
    	outputValid = false;
    	
    	super.enable();	
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
    	if(output > 0) {
    		if(output < minPIDSpeed) {
    			output = minPIDSpeed;
    		}
    		else if(output > maxPIDSpeed) {
    			output = maxPIDSpeed;
    		}
    	}
    	else if(output < 0) {
    		if(output > -minPIDSpeed) {
    			output = -minPIDSpeed;
    		}
    		else if(output < -maxPIDSpeed) {
    			output = -maxPIDSpeed;
    		}
    	}
    	
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
    	if (Math.abs(getPIDController().getSetpoint() - returnPIDInput()) < tolerance) {
    		targetCounter = targetCounter + 1;
    	}
    	else {
    		targetCounter = 0;
    	}
    	
    	return (targetCounter >= RobotPreferences.drivetrainTargetCount());
    }
    
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
