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
		
		if((AutoPreferences.doSwitch() == false) || (AutoPreferences.doScale() == false)) {
			return 0.0;
		}
		
		double angle = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			angle = 90.0;
		}
		else {
			angle = 90.0;
		}
		
		return angle;
	}
	
	public double autoSwitchD1() {
		if(AutoPreferences.isDebug() == false) {
			return RobotPreferences.autoSwitchAfterScaleD1();
		}
		
		if((AutoPreferences.doSwitch() == false) || (AutoPreferences.doScale() == false)) {
			return 0.0;
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			distance = 100.0;
		}
		else {
			distance = 100.0;
		}
		
		return distance;
	}
	
	public double autoSwitchR2() {
		if(AutoPreferences.isDebug() == false) {
			return RobotPreferences.autoSwitchAfterScaleR2();
		}
		
		if((AutoPreferences.doSwitch() == false) || (AutoPreferences.doScale() == false)) {
			return 0.0;
		}
		
		double angle = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			angle = 90.0;
		}
		else {
			angle = 9.0;
		}
		
		return angle;
	}
	
	public double autoSwitchD2() {
		if(AutoPreferences.isDebug() == false) {
			return RobotPreferences.autoSwitchAfterScaleD2();
		}
		
		if((AutoPreferences.doSwitch() == false) || (AutoPreferences.doScale() == false)) {
			return 0.0;
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			distance = 100.0;
		}
		else {
			distance = 100.0;
		}
		
		return distance;
	}
	
	public double autoSwitchD3() {
		if(AutoPreferences.isDebug() == false) {
			return RobotPreferences.autoSwitchAfterScaleD3();
		}
		
		if((AutoPreferences.doSwitch() == false) || (AutoPreferences.doScale() == false)) {
			return 0.0;
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			distance = 100.0;
		}
		else {
			distance = 100.0;
		}
		
		return distance;
	}

    public AutoPlaceSwitchAfterScale() {
    	addSequential(new DriveRotate("AutoPlaceSwitchAfterScaleR1", autoSwitchR1()));
    	addSequential(new DriveDistance("AutoPlaceSwitchAfterScaleD1", autoSwitchD1()));
    	addSequential(new DriveRotate("AutoPlaceSwitchAfterScaleR2", autoSwitchR2()));
    	addSequential(new DriveDistance("AutoPlaceSwitchAfterScaleD2", autoSwitchD2()));
    	//addSequential(new CollectorCollectCube());
    	addSequential(new DriveDistance("AutoPlaceSwitchAfterScaleD3", autoSwitchD3()));
    	//addSequential(new CollectorEject());
    }
}
