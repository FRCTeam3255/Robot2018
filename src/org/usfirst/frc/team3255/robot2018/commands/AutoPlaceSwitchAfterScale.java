package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.AutoPreferences;
import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlaceSwitchAfterScale extends CommandGroup {
	
	public double autoSwitchR1() {
		if(AutoPreferences.isDebug() == false) {
			return RobotPreferences.autoSwitchAfterScaleR1();
		}
		
		double angle = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			angle = 0.0;
		}
		else {
			angle = 0.0;
		}
		
		return angle;
	}
	
	public double autoSwitchD1() {
		if(AutoPreferences.isDebug() == false) {
			return RobotPreferences.autoSwitchAfterScaleD1();
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			distance = 0.0;
		}
		else {
			distance = 0.0;
		}
		
		return distance;
	}
	
	public double autoSwitchR2() {
		if(AutoPreferences.isDebug() == false) {
			return RobotPreferences.autoSwitchAfterScaleR2();
		}
		
		double angle = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			angle = 0.0;
		}
		else {
			angle = 135.0;
		}
		
		return angle;
	}
	
	public double autoSwitchD2() {
		if(AutoPreferences.isDebug() == false) {
			return RobotPreferences.autoSwitchAfterScaleD2();
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			distance = 0.0;
		}
		else {
			distance = 155.0;
		}
		
		return distance;
	}
	
	public double autoSwitchD3() {
		if(AutoPreferences.isDebug() == false) {
			return RobotPreferences.autoSwitchAfterScaleD3();
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			distance = 0.0;
		}
		else {
			distance = 13.0;
		}
		
		return distance;
	}

    public AutoPlaceSwitchAfterScale() {
    	System.out.println("Starting Auto Place Switch After Scale");
    	addSequential(new DriveRotate("AutoPlaceSwitchAfterScaleR1", autoSwitchR1()));
    	addSequential(new DriveStraightDistance("AutoPlaceSwitchAfterScaleD1", autoSwitchD1()));
    	addSequential(new CollectorArmBack());
    	addParallel(new CascadeBottom());
    	addSequential(new DriveRotate("AutoPlaceSwitchAfterScaleR2", autoSwitchR2()));
    	addSequential(new DriveStraightDistance("AutoPlaceSwitchAfterScaleD2", autoSwitchD2()));
    	addParallel(new CollectorCollect());
    	//addSequential(new CollectorCollectCube());
    	addSequential(new DriveStraightDistance("AutoPlaceSwitchAfterScaleD3", autoSwitchD3()));
    	addParallel(new CascadeMoveToSwitch());
    	addSequential(new CollectorFastEject(), 2.0);
    }
}
