package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.AutoPreferences;
import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlaceScale extends CommandGroup {
 
	public double autoScaleD1() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoScaleD1();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doScale() == false) || (lane == 0)) {
			return 0.0;
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			
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
	
	public double autoScaleR1() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoScaleR1();
		}
		
		 int lane = AutoPreferences.getLane();
		 
		 if((AutoPreferences.doScale() == false) || (lane == 0)) {
			 return 0.0;
		 }
		 
		 double angle = 0.0;
		 
		 if(Robot.navigation.getScalePos() == 'R') {
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
	
	public double autoScaleD2() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoScaleD2();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doScale() == false) || (lane == 0)) {
			return 0.0;
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
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
	
	public double autoScaleR2() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoScaleR2();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doScale() == false) || (lane == 0)) {
			return 0.0;
		}
		
		double angle = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
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
	
	public double autoScaleD3() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoScaleD3();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doScale() == false) || (lane == 0)) {
			return 0.0;	
		}
		
		double distance = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
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
	
	public AutoPlaceScale() {
        addSequential(new DriveStraightDistance("PlaceScaleD1", autoScaleD1()));
        addSequential(new DriveRotate("PlaceScaleR1", autoScaleR1()));
        addSequential(new DriveStraightDistance("PlaceScaleD2", autoScaleD2()));
        addSequential(new DriveRotate("PlaceScaleR2", autoScaleR2()));
        //Drivetrain PID
        //addSequential(new DriveDistance("PlaceScaleD3", autoSwitchD3()));
        //Vision PID
        addSequential(new DriveToTarget("PlaceScaleD3", autoScaleD3()));
    }
}
