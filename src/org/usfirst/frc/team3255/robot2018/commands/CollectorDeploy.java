package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

/**
 *
 */
public class CollectorDeploy extends CollectorMove {

    public CollectorDeploy() {
       super();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setPoint = RobotPreferences.collectorDeploySetpoint();
    	super.initialize();
    }
    
    protected boolean isFinished() {
    	if (Robot.collector.getEncoderDistance() >= setPoint) {
    		return true;
    	}
    	else {
    		return super.isFinished();
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.deployCollector();
    	
    	super.end();
    }
}
