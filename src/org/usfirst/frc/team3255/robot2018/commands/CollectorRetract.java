package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

/**
 *
 */
public class CollectorRetract extends CollectorMove {
	
	protected double previousPosition;

    public CollectorRetract() {
       super();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	previousPosition = Robot.lifter.getEncoderDistance();
    	setPoint = RobotPreferences.collectorDeploySetpoint();
    	super.initialize();
    }
    
    protected boolean isFinished() {
    	if (previousPosition >= setPoint) {
    		return true;
    	}
    	else {
    		return super.isFinished();
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.retractCollector();
    	
    	super.end();
    }
}
