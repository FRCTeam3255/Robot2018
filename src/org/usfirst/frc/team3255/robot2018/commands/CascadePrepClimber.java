package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CascadePrepClimber extends Command {

    public CascadePrepClimber() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cascadeLift);
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cascadeLift.shiftToCascade();
    	Robot.cascadeLift.unlockLift();
    	Robot.cascadeLift.setLiftSpeed(0.7);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.cascadeLift.isCascadeTop();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.cascadeLift.setLiftSpeed(0.0);
    	Robot.cascadeLift.lockLift();
    	Robot.cascadeLift.shiftToClimber();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
