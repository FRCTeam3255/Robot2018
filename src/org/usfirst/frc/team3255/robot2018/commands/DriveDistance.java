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
	
    public DriveDistance(String name, double inches) {
        requires(Robot.drivetrain);
        requires(Robot.driveDistancePID);
        
    	distance = inches / 12;
    	commandName = name;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetEncoder();
    	
    	Robot.driveDistancePID.setSetpoint(distance);
    	Robot.driveDistancePID.setAbsoluteTolerance(RobotPreferences.drivetrainTolerance());
    	Robot.driveDistancePID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(Robot.driveDistancePID.getOutput(), 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveDistancePID.onRawTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveDistancePID.disable();
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}