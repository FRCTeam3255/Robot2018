package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {

	double distance;
	String commandName;
	private double expireTime;
	
    public DriveDistance(String name, double inches) {
        requires(Robot.drivetrain);
        requires(Robot.driveDistancePID);
        
    	distance = inches;
    	commandName = name;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.telemetry.setAutonomousStatus("Starting " + commandName + ": " + distance);
    	Robot.drivetrain.resetEncoder();
    	
    	Robot.driveDistancePID.setSetpoint(distance);
    	Robot.driveDistancePID.setRawTolerance(RobotPreferences.drivetrainTolerance());
    	Robot.driveDistancePID.enable();
    	
    	expireTime = timeSinceInitialized() + (RobotPreferences.timeOut());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.telemetry.setAutonomousStatus("Running " + commandName + ": " + distance);
    	Robot.drivetrain.arcadeDrive(Robot.driveDistancePID.getOutput(), 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean distanceTarget = Robot.driveDistancePID.onRawTarget();
    	
    	double timeNow = timeSinceInitialized();
    	
    	return (distanceTarget || (timeNow >= expireTime));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.telemetry.setAutonomousStatus("Finishing " + commandName + ": " + distance);
        Robot.driveDistancePID.disable();
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
