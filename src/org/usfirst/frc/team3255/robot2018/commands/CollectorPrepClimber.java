package org.usfirst.frc.team3255.robot2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectorPrepClimber extends CommandGroup {

    public CollectorPrepClimber() {
    	addSequential(new CollectorMoveToTop());
    	addSequential(new CollectorRetract());
    	
    }
}
