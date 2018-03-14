package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorEject extends Command {
	
	double speed = 0.0;

    public CollectorEject() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.collector.clampCollector();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.speed = -((Robot.oi.manipulatorStick.getRawAxis(RobotMap.COLLECTOR_SPEED_AXIS) -1) / 2);
    	
    	if (speed == 0.0) {
    		speed = 0.25;
    	}
    	
    	Robot.collector.setCollectorSpeed(-speed);
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
