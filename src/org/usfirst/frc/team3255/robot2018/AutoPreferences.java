package org.usfirst.frc.team3255.robot2018;

import edu.wpi.first.wpilibj.Joystick;

public class AutoPreferences {
	
	private static Joystick preferencesStick = new Joystick(RobotMap.JOYSTICK_PREFERENCES);
	
	public static boolean isDebug() {
		return preferencesStick.getRawButton(5);
	}
	
	public static boolean doScale() {
		return preferencesStick.getRawButton(6);
	}

	public static boolean doSwitch() {
		return preferencesStick.getRawButton(7);
	}
	
	public static boolean doDelay() {
		return preferencesStick.getRawButton(8);
	}

	public static int getLane() {
		int lane = 0;
		
		if(preferencesStick.getRawButton(1)) {
			lane = 1;
		}
		else if(preferencesStick.getRawButton(2)) {
			lane = 2;
		}
		else if(preferencesStick.getRawButton(3)) {
			lane = 3;
		}
		else {
			lane = (Robot.telemetry.getDefaultLane());
		}
		
		return lane;
	}	
	
	public static boolean isReset() {
		return preferencesStick.getRawButton(10);
	}
}
