package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorMove extends Command {

	protected double setPoint = 0;
	
    public CollectorMove() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    	requires(Robot.collectorPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.collectorPID.setSetpoint(setPoint);
    	Robot.collectorPID.setRawTolerance(RobotPreferences.collectorTolerance());
    	Robot.collectorPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.collector.setLiftSpeed(Robot.collectorPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.collectorPID.onRawTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collectorPID.disable();
    	Robot.collector.setLiftSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
