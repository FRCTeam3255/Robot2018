package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.AutoPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
    	if(AutoPreferences.doScale() && AutoPreferences.doSwitch()) {
    		addSequential(new AutoPlaceScale());
    		addSequential(new AutoPlaceSwitchAfterScale());
    	}
    	addSequential(new AutoPlaceSwitch());
    	addSequential(new AutoPlaceExchange());
    }
}
