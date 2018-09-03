package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.AutoPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
    	
//    	if(AutoPreferences.doScale() && AutoPreferences.doSwitch()) {
//    		addSequential(new AutoPlaceScale());
//    		addSequential(new AutoPlaceSwitchAfterScale());
//    	}
//    	else if(AutoPreferences.doSwitch()) {
//        	addSequential(new AutoPlaceSwitch());
//    	}
//    	else if (AutoPreferences.doScale()) {
//    		addSequential(new AutoPlaceScale());
//    	}
////    	else if (AutoPreferences.doExchange()) {
////        	addSequential(new AutoPlaceExchange());
////    	}
//    	else {
//    		addSequential(new AutoPlaceSwitch());
    		addSequential(new DriveDistance("Cross Line", 96));
    	}
    }
//}
