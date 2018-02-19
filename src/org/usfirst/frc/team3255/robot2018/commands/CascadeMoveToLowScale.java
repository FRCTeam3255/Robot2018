package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.RobotPreferences;

/**
 *
 */
public class CascadeMoveToLowScale extends CascadeMove {

    public CascadeMoveToLowScale() {
    	super();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setPoint = RobotPreferences.cascadeLiftLowScaleSetpoint();
    	
    	super.initialize();
    }
}