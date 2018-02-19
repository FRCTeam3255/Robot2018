package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.RobotPreferences;

/**
 *
 */
public class CascadeMoveToSwitch extends CascadeMove {

    public CascadeMoveToSwitch() {
    	super();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setPoint = RobotPreferences.cascadeLiftSwitchSetpoint();
    	
    	super.initialize();
    }
}
