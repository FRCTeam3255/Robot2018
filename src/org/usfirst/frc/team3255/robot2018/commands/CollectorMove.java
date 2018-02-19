package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorMove extends Command {

	protected double setPoint = 0;
	private double expireTime;
	
    public CollectorMove() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    	requires(Robot.collectorPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Starting Collector Command");
    	Robot.cascadeLift.unlockLift();
    	Robot.collectorPID.setSetpoint(setPoint);
    	Robot.collectorPID.setRawTolerance(RobotPreferences.collectorTolerance());
    	Robot.collectorPID.enable();
    	
    	expireTime = timeSinceInitialized() + RobotPreferences.timeOut();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Executing Collector Command");
    	Robot.cascadeLift.setLiftSpeed(Robot.collectorPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean collectorTarget = Robot.collectorPID.onRawTarget();
    	
    	double speed = Robot.collectorPID.getOutput();
    	
    	double timeNow = timeSinceInitialized();
    	
    	if((speed >= 0) && (Robot.cascadeLift.isTopSwitchClosed())) {
    		return true;
    	}
    	else if((speed < 0) && (Robot.cascadeLift.isBottomSwitchClosed())) {
    		return true;
    	}
    	
        return (collectorTarget || (timeNow >= expireTime));
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Ending Collector Command");
    	Robot.collectorPID.disable();
    	Robot.cascadeLift.setLiftSpeed(0.0);
    	if(!Robot.cascadeLift.isTopSwitchClosed()) {
    		Robot.cascadeLift.lockLift();
    	}
//    	if(Robot.collector.isBottomSwitchClosed()) {
//    		Robot.collector.resetEncoder();
//    	}
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
