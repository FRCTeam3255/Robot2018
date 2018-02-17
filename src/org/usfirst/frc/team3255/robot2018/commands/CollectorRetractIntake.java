package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CollectorRetractIntake extends InstantCommand {

    public CollectorRetractIntake() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.collector);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.collector.retractCollector();
    }

}
