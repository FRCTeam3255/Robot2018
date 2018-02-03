package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class NavResetYaw extends InstantCommand {

    public NavResetYaw() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.navigation);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.navigation.resetYaw();
    }

}
