package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

/**
 *
 */
public class CollectorMoveToLowScale extends CollectorMove {

    public CollectorMoveToLowScale() {
    	super();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setPoint = RobotPreferences.collectorLowScaleSetpoint();
    	
    	super.initialize();
    }
    
    protected void end() {
    	super.end();
    	
    	Robot.collector.lockLift();
    }
}