package org.usfirst.frc.team3255.robot2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CascadeSwitch extends CommandGroup {

    public CascadeSwitch() {
    	addSequential(new CollectorArmFront());
        addSequential(new CascadeMoveToSwitch());
    }
}
