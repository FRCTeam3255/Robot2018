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
	double outputMaxChange = 1.0;
	double previousOutput = 0.0;
	
	double minPIDSpeed = 0.0;
	double maxPIDSpeed = 1.0;
	double maxDownPIDSpeed = 1.0;
	

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
    			RobotPreferences.cascadeLiftP(),
    			RobotPreferences.cascadeLiftI(),
    			RobotPreferences.cascadeLiftD());
    	
    	minPIDSpeed = RobotPreferences.cascadeLiftPIDMin();
    	maxPIDSpeed = RobotPreferences.cascadeLiftPIDMax();
    	maxDownPIDSpeed = RobotPreferences.cascadeLiftDownMax();
    	
    	outputMaxChange = RobotPreferences.cascadeLiftPIDMaxChange();
    	
    	previousOutput = 0.0;
    	
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
    	return Robot.cascadeLift.getEncoderDistance();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
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
    		else if(output < -maxDownPIDSpeed) {
    			output = -maxDownPIDSpeed;
    		}
    	}
    	
    	previousOutput = output;
    	
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
    	if (Math.abs(getPIDController().getSetpoint() - Robot.cascadeLift.getEncoderDistance()) < tolerance) {
    		targetCounter = targetCounter + 1;
    	}
    	else {
    		targetCounter = 0;
    	}
    	
    	return (targetCounter >= RobotPreferences.cascadeLiftTargetCount());
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
