package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CascadeLiftLock extends InstantCommand {

    public CascadeLiftLock() {
    	super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cascadeLift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cascadeLift.lockLift();
    }
}
