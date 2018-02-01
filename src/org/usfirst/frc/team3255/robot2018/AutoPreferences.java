package org.usfirst.frc.team3255.robot2018;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.Joystick;

public class AutoPreferences {
	
	private static Joystick preferencesStick = new Joystick(RobotMap.JOYSTICK_PREFERENCES);
	
	public static boolean isDebug() {
		return preferencesStick.getRawButton(5);
	}
	
	public static boolean isRedAlliance() {
		if(DriverStation.getInstance().getAlliance() == Alliance.Red) {
			return true;
		}
		return false;
	}

	public static int getLane() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static boolean doSwitch() {
		// TODO Auto-generated method stub
		return false;
	}
}
