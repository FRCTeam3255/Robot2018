package org.usfirst.frc.team3255.robot2018.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DoDelay extends Command {
	
	private double expireTime;
	private double to;

    public DoDelay(double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	to = timeout;
    }
    
    protected void startTimer() {
    	expireTime = timeSinceInitialized() + this.to;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	startTimer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (timeSinceInitialized() >= expireTime);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
