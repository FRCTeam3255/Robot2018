package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class VisionOffsetPID extends PIDSubsystem {
	
	boolean outputValid = false;
	double tolerance = 0.0; 
	double output = 0.0;
	int targetCounter = 0;
	double outputMaxChange = 1.0;
	double previousOutput = 0.0;
	
	double minPIDSpeed = 0.0;
	double maxPIDSpeed = 1.0;

    // Initialize your subsystem here
    public VisionOffsetPID() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(0, 0, 0);
    	this.setSetpoint(0.0);
    }
    
    public void enable() {
    	this.getPIDController().setPID(
    			RobotPreferences.visionOffsetP(),
    			RobotPreferences.visionOffsetI(),
    			RobotPreferences.visionOffsetD());
    	
    	minPIDSpeed = RobotPreferences.yawPIDMin();
    	maxPIDSpeed = RobotPreferences.yawPIDMax();
    	
    	outputMaxChange = RobotPreferences.rotatePIDMaxChange();
    	
    	previousOutput = 0.0;
    	
    	outputValid = false;
    	
    	super.enable();
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return Robot.navigation.getCubeOffset();
    }

    protected void usePIDOutput(double output) {
    	if(Math.abs(output - previousOutput) > outputMaxChange) {
    		output = output - previousOutput > 0 ? previousOutput + outputMaxChange : previousOutput - outputMaxChange;
    	}
    	
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
    	
    	previousOutput = output;
    	
    	this.output = output;
    	outputValid = true;
    }
    
    public double getOutput() {
    	if(this.getPIDController().isEnabled() == false || outputValid == false) {
    		return 0.0;
    	}
    	return output;
    }
    
    public void setRawTolerance(double tolerance) {
    	this.tolerance = tolerance;
    }
    
    public boolean onRawTarget() {
    	if (Math.abs(Robot.visionOffsetPID.getSetpoint() - Robot.navigation.getTargetOffset()) <= tolerance) {
    		targetCounter = targetCounter + 1;
    	}
    	else {
    		targetCounter = 0;
    	}
    	
    	return targetCounter >= RobotPreferences.visionTargetCount();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
