package org.usfirst.frc.team3255.robot2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectorClimb extends CommandGroup {

    public CollectorClimb() {
    	addSequential(new CollectorClimberSetSpeed());
    }
}
