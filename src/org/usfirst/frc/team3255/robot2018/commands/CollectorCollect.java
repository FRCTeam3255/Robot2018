package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectorCollect extends CommandGroup {

    public CollectorCollect() {	
//    	if (isBottom()) {
    		addSequential(new CollectorMoveToBottom());
//    	}
    	addSequential(new CollectorCollectCube());
//    	addSequential(new CollectorResetEncoder());
    }
    
    public boolean isBottom() {
		return Robot.collector.isBottomSwitchClosed();
    	
    }
}
