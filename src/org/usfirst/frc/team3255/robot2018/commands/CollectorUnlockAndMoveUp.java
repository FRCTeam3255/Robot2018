package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;

/**
 *
 */
public class CollectorUnlockAndMoveUp extends CollectorMove {

    public CollectorUnlockAndMoveUp() {
    	super();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setPoint = (Robot.collector.getEncoderDistance() + 5.0);
    	
    	super.initialize();
    }
}
