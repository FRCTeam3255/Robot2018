package org.usfirst.frc.team3255.robot2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectorCollect extends CommandGroup {

    public CollectorCollect() {
    	
    	addSequential(new CollectorMoveToBottom());
    	addSequential(new CollectorStartCollecting());
    	
    }
}
