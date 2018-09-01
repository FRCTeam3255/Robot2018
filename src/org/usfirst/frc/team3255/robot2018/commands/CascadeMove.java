package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CascadeMove extends Command {

	protected double setPoint = 0;
	private double expireTime;
	
    public CascadeMove() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cascadeLift);
    	requires(Robot.collectorPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cascadeLift.shiftToCascade();
    	Robot.cascadeLift.unlockLift();
    	Robot.collectorPID.setSetpoint(setPoint);
    	Robot.collectorPID.setRawTolerance(RobotPreferences.cascadeLiftTolerance());
    	Robot.collectorPID.enable();
    	
    	expireTime = timeSinceInitialized() + RobotPreferences.timeOut();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.cascadeLift.setLiftSpeed(Robot.collectorPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean collectorTarget = Robot.collectorPID.onRawTarget();
    	
    	double speed = Robot.collectorPID.getOutput();
    	
    	double timeNow = timeSinceInitialized();
    	
    	if((speed >= 0) && (Robot.cascadeLift.isCascadeTop())) {
    		return true;
    	}
    	else if((speed < 0) && (Robot.cascadeLift.isCascadeBottom())) {
    		return true;
    	}
    	
        return (collectorTarget || (timeNow >= expireTime));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collectorPID.disable();
    	Robot.cascadeLift.setLiftSpeed(0.0);
    	if(!Robot.cascadeLift.isCascadeTop()) {
    		Robot.cascadeLift.lockLift();
    	}   	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
