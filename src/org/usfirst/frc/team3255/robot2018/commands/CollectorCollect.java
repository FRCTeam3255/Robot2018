package org.usfirst.frc.team3255.robot2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectorCollect extends CommandGroup {

    public CollectorCollect() {	
    	addSequential(new CascadeMoveToBottom());
    	addSequential(new CollectorDeployIntake());
    	addSequential(new CollectorCollectCube());
    	addSequential(new CascadeResetEncoder());
    }
}
