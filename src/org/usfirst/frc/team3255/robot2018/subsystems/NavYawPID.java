package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class NavYawPID extends PIDSubsystem {
	
	double output = 0.0;
	boolean outputValid = false;
	int targetCounter = 0;
	double tolerance = 0.0;

    // Initialize your subsystem here
    public NavYawPID() {
    	super(0,0,0);
    	this.setSetpoint(0.00);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	setRawTolerance(RobotPreferences.yawTolerance());
    }

    public void enable() {
    	this.getPIDController().setPID(
    			RobotPreferences.navYawP(),
    			RobotPreferences.nawYawI(),
    			RobotPreferences.nawYawD());
    	
    	setAbsoluteTolerance(RobotPreferences.yawTolerance());
    	
    	double maxSpeed = RobotPreferences.maxYawSpeed();
    	this.setOutputRange(-maxSpeed, maxSpeed);
    	
    	outputValid = false;
    	
    	super.enable();
    }
    
    private double getCalculatedYaw() {
    	//Return your input value for the PID loop
    	//e.g a sensor, like a potentiometer:
    	//yourPot.getAverageVoltage() /kYourMaxVoltage;
    	double yaw = Robot.navigation.getYaw();
    	
    	return yaw;
    }
    
    protected double returnPIDInput() {
    	return getCalculatedYaw();
    }
    
    protected void usePIDOutput(double output) {
    	//Use output to drive to drive your system, like a motor
    	// e.g yourMotor.set(output);
    	this.output = output;
    	outputValid = true;
    }
    
    public double getOutput() {
    	if(this.getPIDController().isEnabled() == false || outputValid == false) {
    		return 0.0;
    	}
    	
    	double minYaw = RobotPreferences.minYawSpeed();
    	
    	if(Math.abs(output) < minYaw) {
    		if(output< 0) {
    			output = -minYaw;
    		}
    		else {
    			output = minYaw;
    		}
    	}
    	
    	return output;
    }
    public void setRawTolerance(double tolerance) {
    	this.tolerance = tolerance;
    }
    
    public boolean onRawTarget() {
    	if (Math.abs(getPIDController().getSetpoint() - getCalculatedYaw()) < tolerance) {
    		targetCounter = targetCounter +1;
    	}
    	else {
    		targetCounter = 0;
    	}
    	return (targetCounter >= RobotPreferences.yawTargetCount());
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

  