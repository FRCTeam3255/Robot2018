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
		
		double distance = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			
			if(lane == 1) {
				distance = 218.0;
			}
			else if(lane == 2) {
				distance = 0.0;
			}
			else if(lane == 3) {
				distance = 218.0;
			}
		}
		else {
			if(lane == 1) {
				distance = 218.0;
			}
			else if(lane == 2) {
				distance = 0.0;
			}
			else if(lane == 3) {
//				distance = 198.0;
				distance = 218.0;
			}
		}
		
		return distance;
	}
	
	public double autoScaleR1() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoScaleR1();
		}
		
		 int lane = AutoPreferences.getLane();
		 
		 double angle = 0.0;
		 
		 if(Robot.navigation.getScalePos() == 'R') {
			 if (lane == 1) {
				 angle = 90.0;
			 }
			 else if(lane == 2) {
				 angle = 0.0;
			 }
			 else if(lane == 3) {
				 angle = -30.0;
			 } 
		 }
		 else {
			 if (lane == 1) {
				 angle = 33.0;
			 }
			 else if(lane == 2) {
				 angle = 0.0;
			 }
			 else if(lane == 3) {
				 angle = -90.0;
			 }
		 }
		 
		 return angle;
	}
	
	public double autoScaleD2() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoScaleD2();
		}
		
		int lane = AutoPreferences.getLane();
		
		double distance = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			if (lane == 1) {
				distance = 197.0;
			}
			else if(lane == 2) {
				distance = 0;
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
				distance = 0;
			}
			else if (lane == 3) {
//				distance = 183.0;
				distance = 197.0;
			}
		}
		
		return distance;
	}
	
	public double autoScaleR2() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoScaleR2();
		}
		
		int lane = AutoPreferences.getLane();
		
		double angle = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			if (lane == 1) {
				angle = -93.0;
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
				angle = 0.0;
			}
			else if (lane == 2) {
				angle = 0.0;
			}
			else if (lane == 3) {
				angle = 93.0;
			}
		}
		
		return angle;
	}
	
	public double autoScaleD3() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoScaleD3();
		}
		
		int lane = AutoPreferences.getLane();
		
		double distance = 0.0;
		
		if(Robot.navigation.getScalePos() == 'R') {
			if (lane == 1) {
				distance = 44.0;
			}
			else if (lane == 2) {
				distance = 0.0;
			}
			else if (lane == 3) {
				distance = 47.0;
			}
		}
		else {
			if (lane == 1) {
				distance = 47.0;
			}
			else if (lane == 2) {
				distance = 0.0;
			}
			else if (lane == 3) {
//				distance = 15.0;
				distance = 38.0;
			}
		}
		
		return distance;
	}
	
	public AutoPlaceScale() {
		addSequential(new DriveDualStraightDistance("PlaceScaleD1", autoScaleD1()));
        addSequential(new DriveRotate("PlaceScaleR1", autoScaleR1()));
        addSequential(new DriveDualStraightDistance("PlaceScaleD2", autoScaleD2()));
        addSequential(new DriveRotate("PlaceScaleR2", autoScaleR2()));
        addSequential(new CollectorArmFront());
        addParallel(new CascacdeMoveToHighScale());
        addSequential(new DriveDistance("PlaceScaleD3", autoScaleD3()));
        addSequential(new CollectorFastEject(), 2.0);
    }
}
