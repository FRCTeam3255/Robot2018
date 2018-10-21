package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.AutoPreferences;
import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlaceSwitch extends CommandGroup {
 
	public static double autoSwitchD1() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoSwitchD1();
		}
		
		int lane = AutoPreferences.getLane();
		
		double distance = 0.0;
		
		if(Robot.navigation.getAllianceSwitchPos() == 'R') {
			
			if(lane == 1) {
				distance = 42.0;
			}
			else if(lane == 2) {
				distance = 13.0;
			}
			else if(lane == 3) {
				distance = 0.0;
				//97.0
			}
		}
		else {
			if(lane == 1) {
//				distance = 97.0;
				distance = 0.0;
			}
			else if(lane == 2) {
//				distance = 13.0;
				distance = 0.0;
			}
			else if(lane == 3) {
				distance = 42.0;
			}
		}
		
		return distance;
	}
	
	public static double autoSwitchR1() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoSwitchR1();
		}
		
		 int lane = AutoPreferences.getLane();
		 
		 double angle = 0.0;
		 
		 if(Robot.navigation.getAllianceSwitchPos() == 'R') {
			 if (lane == 1) {
				 angle = 90.0;
			 }
			 else if(lane == 2) {
//				 angle = 23.0;
				 angle = 0.0;
			 }
			 else if(lane == 3) {
				 angle = 0.0;
			 } 
		 }
		 else {
			 if (lane == 1) {
//				 angle = 16.0;
				 angle = 0.0;
			 }
			 else if(lane == 2) {
//				 angle = -31.0;
				 angle = 0.0;
			 }
			 else if(lane == 3) {
				 angle = -90.0;
			 }
		 }
		 
		 return angle;
	}
	
	public static double autoSwitchD2() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoSwitchD2();
		}
		
		int lane = AutoPreferences.getLane();
		
		double distance = 0.0;
		
		if(Robot.navigation.getAllianceSwitchPos() == 'R') {
			if (lane == 1) {
				distance = 96.0;
			}
			else if(lane == 2) {
				distance = 0.0;
				//94.0
			}
			else if(lane == 3) {
				distance = 0.0;
			}
		}
		else {
			if (lane == 1) {
				distance = 0.0;
			}
			else if (lane == 2) {
				distance = 11.0;
				//100
			}
			else if (lane == 3) {
				distance = 82.0;
			}
		}
		
		return distance;
	}
	
	public static double autoSwitchR2() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoSwitchR2();
		}
		
		int lane = AutoPreferences.getLane();
		
		double angle = 0.0;
		
		if(Robot.navigation.getAllianceSwitchPos() == 'R') {
			if (lane == 1) {
				angle = -64.0;
			}
			else if (lane == 2) {
				angle = 23.0;
			}
			else if (lane == 3) {
				angle = 0.0;
			}
		}
		else {
			if (lane == 1) {
				angle = 0.0;
			}
			else if (lane == 2) {
				angle = -31.0;
			}
			else if (lane == 3) {
				angle = 64.0;
			}
		}
		
		return angle;
	}
	
	public static double autoSwitchD3() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoSwitchD3();
		}
		
		int lane = AutoPreferences.getLane();
		
		double distance = 0.0;
		
		if(Robot.navigation.getAllianceSwitchPos() == 'R') {
			if (lane == 1) {
				distance = 66.0;
				//66.0
			}
			else if (lane == 2) {
				distance = 96.0;
				//94
			}
			else if (lane == 3) {
				distance = 104.0;
			}
		}
		else {
			if (lane == 1) {
				distance = 104.0;
			}
			else if (lane == 2) {
				distance = 98.0;
				//103
			}
			else if (lane == 3) {
				distance = 68.0;
				//66
			}
		}
		
		return distance;
	}
	
	public static double autoSwitchR3() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoSwitchR3();
		}
		
		int lane = AutoPreferences.getLane();
		
		double angle = 0.0;
		
		if(Robot.navigation.getAllianceSwitchPos() == 'R') {
			if (lane == 1) {
				angle = 0.0;
			}
			else if (lane == 2) {
				angle = 0.0;
			}
			else if (lane == 3) {
				angle = 0.0;
			}
		}
		else {
			if (lane == 1) {
				angle = 16.0;
			}
			else if (lane == 2) {
				angle = 0.0;
			}
			else if (lane == 3) {
				angle = 0.0;
			}
		}
		
		return angle;
	}
	
	public static double delay() {
		if(AutoPreferences.doDelay()) {
			return 2.0;
		}
		return 0.0;
	}
	
	public AutoPlaceSwitch() {
		addSequential(new DoDelay(delay()));
        addSequential(new DriveStraightDistance("PlaceSwitchD1", autoSwitchD1()));
        addSequential(new DriveRotate("PlaceSwitchR1", autoSwitchR1()));
        addSequential(new DriveStraightDistance("PlaceSwitchD2", autoSwitchD2()));
        addSequential(new DriveRotate("PlaceSwitchR2", autoSwitchR2()));
        //Drivetrain PID
        addParallel(new CascadeSwitch());
        addSequential(new DriveStraightDistance("PlaceSwitchD3", autoSwitchD3()));
        addSequential(new DriveRotate("PlaceSwitchR3", autoSwitchR3()));
        //Vision PID
//        addSequential(new DriveToTarget("PlaceSwitchD3", autoSwitchD3()));
        addSequential(new CollectorSlowEject(), 2.0);
    }
}
