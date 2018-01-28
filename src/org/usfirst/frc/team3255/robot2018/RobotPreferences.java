package org.usfirst.frc.team3255.robot2018;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	public static double drivetrainMaxSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("DrivetrainMaxSpeed", 1.0);
	}

	public static double collectorP() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CollectorP", 1.0);
	}

	public static double collectorI() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("CollectorI", 0.0);
	}

	public static double collectorD() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("CollectorD", 0.0);
	}

	public static double collectorMaxSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CollectorMaxSpeed", 1.0);
	}

	public static int collectorTargetCount() {
		if(AutoPreferences.isDebug() == false) {
			return 0;
		}
		return Preferences.getInstance().getInt("CollectorTargetCount", 0);
	}

	public static double collectorTolerance() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		
		return Preferences.getInstance().getDouble("CollectorTolerance", 1.0);
	}

	public static double collectorBottomSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("CollectorBottomSetpoint", 0.0);
	}
	
	public static double collectorSwitchSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 10.0;
		}
		return Preferences.getInstance().getDouble("CollectorSwitchSetpoint", 10.0);
	}

	public static double collectorLowScaleSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 20.0;
		}
		return Preferences.getInstance().getDouble("CollectorLowScaleSetpoint", 20.0);
	}

	public static double collectorMedScaleSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 30.0;
		}
		return Preferences.getInstance().getDouble("CollectorMedScaleSetpoint", 30.0);
	}

	public static double collectorHighScaleSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 40.0;
		}
		return Preferences.getInstance().getDouble("CollectorHighScaleSetpoint", 40.0);
	}

	public static double collectorCollectSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CollectorCollectSpeed", 1.0);
	}

	public static double collectorEjectSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return -1.0;
		}
		return Preferences.getInstance().getDouble("CollectorEjectSpeed", -1.0);
	}

	public static double drivetrainP() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("DrivetrainP", 1.0);
	}

	public static double drivetrainI() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("DrivetrainI", 0.0);
	}

	public static double drivetrainD() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("DrivetrainD", 0.0);
	}

	public static int drivetrainTargetCount() {
		if(AutoPreferences.isDebug() == false) {
			return 0;
		}
		return Preferences.getInstance().getInt("DrivetrainTargetCount", 0);
	}

	public static double yawTolerance() {
		if(AutoPreferences.isDebug() == false) {
			return 5.0;
		}
		return Preferences.getInstance().getDouble("YawTolerance", 5.0);
	}

	public static double navYawP() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("NavYawP", 1.0);
	}

	public static double navYawI() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("NavYawI", 0.0);
	}

	public static double navYawD() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("NavYawD", 0.0);
	}

	public static double maxYawSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("MaxYawSpeed", 1.0);
	}
	
	public static double minYawSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("MinYawSpeed", 0.0);
	}
	
	public static int yawTargetCount() {
		if(AutoPreferences.isDebug() == false) {
			return 0;
		}
		return Preferences.getInstance().getInt("YawTargetCount", 0);
	}

	public static int drivetrainPulsePerFoot() {
		if(AutoPreferences.isDebug() == false) {
			return 1;
		}
		return Preferences.getInstance().getInt("DrivetrainPulsePerFoot", 1);
	}

	public static int collectorPulsesPerFoot() {
		if(AutoPreferences.isDebug() == false) {
			return 1;
		}
		return Preferences.getInstance().getInt("CollectorPulsesPerFoot", 1);
	}

	public static double climberExtendSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("ClimberExtendSpeed", 1.0);
	}

	public static double climberRetractSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return -1.0;
		}
		return Preferences.getInstance().getDouble("ClimberRetractSpeed", -1.0);
	}
}
