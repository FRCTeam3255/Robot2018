package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VisionDriveCubeCollected extends Command {
	
	String commandName;
	private double expireTime;
	int held = 0;

    public VisionDriveCubeCollected(String name) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.collector);
    	requires(Robot.drivetrainDistanceVisionPID);
    	requires(Robot.visionOffsetPID);
    	
    	commandName = name;

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.telemetry.setAutonomousStatus("Starting " + commandName);
    	Robot.collector.setCollectorSpeed(RobotPreferences.collectorCollectSpeed());
    	
    	Robot.visionOffsetPID.setSetpoint(0.0);
    	Robot.visionOffsetPID.setRawTolerance(RobotPreferences.visionOffsetTolerance());
    	Robot.visionOffsetPID.enable();
    	
    	expireTime = timeSinceInitialized() + RobotPreferences.timeOut();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.telemetry.setAutonomousStatus("Running " + commandName);
    	Robot.drivetrain.arcadeDrive(RobotPreferences.distancePIDMaxSpeed(), Robot.visionOffsetPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean cubeCollected = Robot.collector.isCubeCollected();
        double timeNow = timeSinceInitialized();
        
        if (cubeCollected) {
        	held = held + 1;
        }
        else {
        	held = 0;
        }
       
        return(held > RobotPreferences.collectorCubeDelay() || (timeNow >= expireTime));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.telemetry.setAutonomousStatus("Finishing " + commandName);
    	Robot.collector.setCollectorSpeed(0.0);
    	Robot.visionOffsetPID.disable();
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
