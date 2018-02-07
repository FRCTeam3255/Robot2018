package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.AutoPreferences;
import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlaceExchange extends CommandGroup {
 
	public double autoExchangeD1() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoExchangeD1();
		}
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doExchange() == false) || (lane == 0)) {
			return 0.0;
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getAllianceSwitchPos() == 'R') {
		//Below is for if CommandGroup has right and left data.
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
	
	public double autoExchangeR1() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoExchangeR1();
		}
		 int lane = AutoPreferences.getLane();
		 
		 if((AutoPreferences.doExchange() == false) || (lane == 0)) {
			 return 0.0;
		 }
		 
		 double angle = 0.0;
		 
		 //Below is for if CommandGroup has right and left data.
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

			 if (lane == 1) {
				 angle = 10.0;
			 }
			 else if(lane == 2) {
				 angle = 10.0;
			 }
			 else if(lane == 3) {
				 angle = 10.0;
			 }
		 
		 return angle;
	}
	
	public double autoExchangeD2() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoExchangeD2();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doExchange() == false) || (lane == 0)) {
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
			if (lane == 1) {
				distance = 10.0;
			}
			else if (lane == 2) {
				distance = 10.0;
			}
			else if (lane == 3) {
				distance = 10.0;
			}
		
		return distance;
		
	}
	
	public double autoExchangeR2() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoExchangeR2();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doExchange() == false) || (lane == 0)) {
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
			if (lane == 1) {
				angle = 10.0;
			}
			else if (lane == 2) {
				angle = 10.0;
			}
			else if (lane == 3) {
				angle = 10.0;
			}
		
		return angle;
	}
	
	public double autoExchangeD3() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoExchangeD3();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doExchange() == false) || (lane == 0)) {
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
			if (lane == 1) {
				distance = 10.0;
			}
			else if (lane == 2) {
				distance = 10.0;
			}
			else if (lane == 3) {
				distance = 10.0;
			}
		
		return distance;
	}
	
	public AutoPlaceExchange() {
        addSequential(new DriveDistance("PlaceSwitchD1", autoExchangeD1()));
        addSequential(new DriveRotate("PlaceSwitchR1", autoExchangeR1()));
        addSequential(new DriveDistance("PlaceSwitchD2", autoExchangeD2()));
        addSequential(new DriveRotate("PlaceSwitchR2", autoExchangeR2()));
        //Drivetrain PID
        //addSequential(new DriveDistance("PlaceSwitchD3", autoSwitchD3()));
        //Vision PID
        addSequential(new DriveToTarget("PlaceSwitchD3", autoExchangeD3()));
    }
}
