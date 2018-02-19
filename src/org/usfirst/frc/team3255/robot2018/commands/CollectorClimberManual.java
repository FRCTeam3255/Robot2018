package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorClimberManual extends Command {

    public CollectorClimberManual() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cascadeLift.unlockLift();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.collector.setClimberSpeed(RobotPreferences.climberExtendSpeed());
    	Robot.collector.setClimberSpeed(-Robot.oi.manipulatorStick.getRawAxis(RobotMap.COLLECTOR_MOVE_AXIS));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.setClimberSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
