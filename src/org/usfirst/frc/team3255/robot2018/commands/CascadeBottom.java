package org.usfirst.frc.team3255.robot2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CascadeBottom extends CommandGroup {

    public CascadeBottom() {
    	addSequential(new CollectorArmFront());
        addSequential(new CascadeMoveToBottom());
        addSequential(new CascadeLiftUnlock());
    }
}
