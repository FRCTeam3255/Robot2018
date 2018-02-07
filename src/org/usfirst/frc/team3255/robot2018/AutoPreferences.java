package org.usfirst.frc.team3255.robot2018;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.Joystick;

public class AutoPreferences {
	
	private static Joystick preferencesStick = new Joystick(RobotMap.JOYSTICK_PREFERENCES);
	
	public static boolean isDebug() {
		return preferencesStick.getRawButton(5);
	}
	
	public static boolean doSwitch() {
		return preferencesStick.getRawButton(10);
	}
	
	public static boolean isRedAlliance() {
		if(DriverStation.getInstance().getAlliance() == Alliance.Red) {
			return true;
		}
		return false;
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
		
		return lane;
	}

	public static boolean doScale() {
		return preferencesStick.getRawButton(4);
	}

	public static boolean doExchange() {
		return preferencesStick.getRawButton(6);
	}	
}
