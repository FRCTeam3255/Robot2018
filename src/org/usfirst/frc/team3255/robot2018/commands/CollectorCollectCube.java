package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorCollectCube extends Command {
	
	int held = 0;

    public CollectorCollectCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    	requires(Robot.lighting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	held = 0;
    	
    	Robot.collector.clampCollector();

    	double speed = RobotPreferences.collectorCollectSpeed();
    	Robot.collector.setCollectorSpeed(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean collected = Robot.collector.isCubeCollected();
    	
    	if(collected) {
    		held = held + 1;
    	}
    	else {
    		held = 0;
    	}
    	
        return (held > RobotPreferences.collectorCubeDelay());
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
