package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;
import org.usfirst.frc.team3255.robot2018.subsystems.Lighting;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorCollectCube extends Command {

    public CollectorCollectCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    	requires(Robot.lighting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
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
        	Robot.lighting.setLighting(Lighting.CUBE_COLLECTED);    		
    	}
    	
        return collected;
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
