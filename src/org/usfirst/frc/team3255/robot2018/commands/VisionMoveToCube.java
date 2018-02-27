package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;
import org.usfirst.frc.team3255.robot2018.subsystems.Lighting;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VisionMoveToCube extends Command {
	
	String commandName;
	double distance;
	private double expireTime;

    public VisionMoveToCube(String name, double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.drivetrainDistanceVisionPID);
    	requires(Robot.visionOffsetPID);
    	
    	this.distance = distance;
    	commandName = name;

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.telemetry.setAutonomousStatus("Starting " + commandName + ": " + distance );
    	Robot.drivetrainDistanceVisionPID.setSetpoint(distance);
    	Robot.drivetrainDistanceVisionPID.setRawTolerance(RobotPreferences.visionDistanceTolerance());
    	Robot.drivetrainDistanceVisionPID.enable();
    	
    	Robot.visionOffsetPID.setSetpoint(0.0);
    	Robot.visionOffsetPID.setRawTolerance(RobotPreferences.visionOffsetTolerance());
    	Robot.visionOffsetPID.enable();
    	
    	expireTime = timeSinceInitialized() + RobotPreferences.timeOut();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.telemetry.setAutonomousStatus("Running " + commandName + ": " + distance);
    	Robot.drivetrain.arcadeDrive(Robot.drivetrainDistanceVisionPID.getOutput(), 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean distanceTarget = Robot.drivetrainDistanceVisionPID.onRawTarget();
        boolean offsetTarget = Robot.visionOffsetPID.onRawTarget();
        
        double timeNow = timeSinceInitialized();
        
        if(offsetTarget) {
        	Robot.lighting.setLighting(Lighting.CUBE_ALIGNED);
        }
        else if(Robot.navigation.isTargetFound()) {
        	Robot.lighting.setLighting(Lighting.CUBE_IDENTIFIED);
        }
        
        return((distanceTarget && offsetTarget) || (timeNow >= expireTime));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.telemetry.setAutonomousStatus("Finishing " + commandName + ": " + distance);
    	Robot.drivetrainDistanceVisionPID.disable();
    	Robot.visionOffsetPID.disable();
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
