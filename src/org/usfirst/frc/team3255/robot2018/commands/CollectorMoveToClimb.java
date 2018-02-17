package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

/**
 *
 */
public class CollectorMoveToClimb extends CollectorMove {

    public CollectorMoveToClimb() {
    	super();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.collector.retractCollector();
    	
    	setPoint = RobotPreferences.collectorClimberSetpoint();
    	
    	super.initialize();
    }
}
