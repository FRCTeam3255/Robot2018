package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.RobotPreferences;

/**
 *
 */
public class CascadeMoveToBottom extends CascadeMove {

    public CascadeMoveToBottom() {
    	super();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setPoint = RobotPreferences.cascadeLiftBottomSetpoint();
    	
    	super.initialize();
    }
    
}
