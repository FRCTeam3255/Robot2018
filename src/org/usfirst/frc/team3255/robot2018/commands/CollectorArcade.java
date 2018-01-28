package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorArcade extends Command {

    public CollectorArcade() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		double moveSpeed = Robot.oi.manipulatorStick.getRawAxis(RobotMap.COLLECTOR_MOVE_AXIS);
		double rotateSpeed = Robot.oi.manipulatorStick.getRawAxis(RobotMap.COLLECTOR_ROTATE_AXIS);
		
    	Robot.collector.arcadeCollect(moveSpeed, rotateSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.setCollectorSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
