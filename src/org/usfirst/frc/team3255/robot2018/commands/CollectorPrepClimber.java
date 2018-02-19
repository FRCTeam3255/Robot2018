package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorPrepClimber extends Command {

    public CollectorPrepClimber() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cascadeLift.unlockLift();
    	Robot.collector.retractCollector();
    	Robot.cascadeLift.setLiftSpeed(0.7);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.cascadeLift.isTopSwitchClosed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.cascadeLift.setLiftSpeed(0.0);
    	Robot.cascadeLift.lockLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
