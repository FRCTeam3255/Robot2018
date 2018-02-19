package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.RobotPreferences;

/**
 *
 */
public class CascacdeMoveToHighScale extends CascadeMove {

    public CascacdeMoveToHighScale() {
    	super();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setPoint = RobotPreferences.cascadeLiftHighScaleSetpoint();
    	
    	super.initialize();
    }
}
