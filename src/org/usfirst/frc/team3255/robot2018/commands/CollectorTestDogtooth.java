package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorTestDogtooth extends Command {

	protected double setPoint = 0;
	
    public CollectorTestDogtooth() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    	requires(Robot.collectorPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.collector.unlockLift();
    	Robot.collector.setLiftSpeed(0.3);
    	Timer.delay(0.1);
    	Robot.collector.setLiftSpeed(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("YAY");
    	Robot.collector.setLiftSpeed(0.0);
//    	Robot.collectorPID.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
