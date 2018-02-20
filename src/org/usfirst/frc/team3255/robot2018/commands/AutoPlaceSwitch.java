package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.AutoPreferences;
import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlaceSwitch extends CommandGroup {
 
	public double autoSwitchD1() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoSwitchD1();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doSwitch() == false) || (lane == 0)) {
			return 0.0;
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getAllianceSwitchPos() == 'R') {
			
			if(lane == 1) {
				distance = 10.0;
			}
			else if(lane == 2) {
				distance = 10.0;
			}
			else if(lane == 3) {
				distance = 10.0;
			}
		}
		else {
			if(lane == 1) {
				distance = 10.0;
			}
			else if(lane == 2) {
				distance = 10.0;
			}
			else if(lane == 3) {
				distance = 10.0;
			}
		}
		
		return distance;
	}
	
	public double autoSwitchR1() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoSwitchR1();
		}
		
		 int lane = AutoPreferences.getLane();
		 
		 if((AutoPreferences.doSwitch() == false) || (lane == 0)) {
			 return 0.0;
		 }
		 
		 double angle = 0.0;
		 
		 if(Robot.navigation.getAllianceSwitchPos() == 'R') {
			 if (lane == 1) {
				 angle = 10.0;
			 }
			 else if(lane == 2) {
				 angle = 10.0;
			 }
			 else if(lane == 3) {
				 angle = 10.0;
			 } 
		 }
		 else {
			 if (lane == 1) {
				 angle = 10.0;
			 }
			 else if(lane == 2) {
				 angle = 10.0;
			 }
			 else if(lane == 3) {
				 angle = 10.0;
			 }
		 }
		 
		 return angle;
	}
	
	public double autoSwitchD2() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoSwitchD2();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doSwitch() == false) || (lane == 0)) {
			return 0.0;
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getAllianceSwitchPos() == 'R') {
			if (lane == 1) {
				distance = 10.0;
			}
			else if(lane == 2) {
				distance = 10.0;
			}
			else if(lane == 3) {
				distance = 10.0;
			}
		}
		else {
			if (lane == 1) {
				distance = 10.0;
			}
			else if (lane == 2) {
				distance = 10.0;
			}
			else if (lane == 3) {
				distance = 10.0;
			}
		}
		
		return distance;
	}
	
	public double autoSwitchR2() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoSwitchR2();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doSwitch() == false) || (lane == 0)) {
			return 0.0;
		}
		
		double angle = 0.0;
		
		if(Robot.navigation.getAllianceSwitchPos() == 'R') {
			if (lane == 1) {
				angle = 10.0;
			}
			else if (lane == 2) {
				angle = 10.0;
			}
			else if (lane == 3) {
				angle = 10.0;
			}
		}
		else {
			if (lane == 1) {
				angle = 10.0;
			}
			else if (lane == 2) {
				angle = 10.0;
			}
			else if (lane == 3) {
				angle = 10.0;
			}
		}
		
		return angle;
	}
	
	public double autoSwitchD3() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoSwitchD3();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doSwitch() == false) || (lane == 0)) {
			return 0.0;	
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getAllianceSwitchPos() == 'R') {
			if (lane == 1) {
				distance = 10.0;
			}
			else if (lane == 2) {
				distance = 10.0;
			}
			else if (lane == 3) {
				distance = 10.0;
			}
		}
		else {
			if (lane == 1) {
				distance = 10.0;
			}
			else if (lane == 2) {
				distance = 10.0;
			}
			else if (lane == 3) {
				distance = 10.0;
			}
		}
		
		return distance;
	}
	
	public AutoPlaceSwitch() {
        addSequential(new DriveDistance("PlaceSwitchD1", autoSwitchD1()));
        addSequential(new DriveRotate("PlaceSwitchR1", autoSwitchR1()));
        addSequential(new DriveDistance("PlaceSwitchD2", autoSwitchD2()));
        addSequential(new DriveRotate("PlaceSwitchR2", autoSwitchR2()));
        //Drivetrain PID
        addSequential(new DriveDistance("PlaceSwitchD3", autoSwitchD3()));
        //Vision PID
//        addSequential(new DriveToTarget("PlaceSwitchD3", autoSwitchD3()));
    }
}
