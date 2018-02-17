package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.RobotPreferences;

/**
 *
 */
public class CollectorMoveToSwitch extends CollectorMove {

    public CollectorMoveToSwitch() {
    	super();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setPoint = RobotPreferences.collectorSwitchSetpoint();
    	
    	super.initialize();
    }
}
