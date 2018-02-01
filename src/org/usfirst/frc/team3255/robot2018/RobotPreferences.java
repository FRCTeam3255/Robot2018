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
			return 1;
		}
		return Preferences.getInstance().getInt("CollectorTargetCount", 1);
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
			return 1;
		}
		return Preferences.getInstance().getInt("DrivetrainTargetCount", 1);
	}
	
	public static double drivetrainTolerance() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return 1.0;
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
			return 1;
		}
		return Preferences.getInstance().getInt("YawTargetCount", 1);
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

	public static int visionTargetCount() {
		if(AutoPreferences.isDebug() == false) {
			return -1;
		}
		return Preferences.getInstance().getInt("VisionTargetCount", 1);
	}

	public static double visionDistanceP() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("VisionDistanceP", 1.0);
	}

	public static double visionDistanceI() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("VisionDistanceI", 0.0);
	}

	public static double visionDistanceD() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("VisionDistanceD", 0.0);
	}

	public static double visionOffsetP() {
		if(AutoPreferences.isDebug() == false) {
		return 1.0;
		}
		return Preferences.getInstance().getDouble("VisionOffsetP", 1.0);
	}

	public static double visionOffsetI() {
		if(AutoPreferences.isDebug() == false) {
		return 0.0;
		}
		return Preferences.getInstance().getDouble("VisionOffsetI", 0.0);
	}

	public static double visionOffsetD() {
		if(AutoPreferences.isDebug() == false) {
		return 0.0;
		}
		return Preferences.getInstance().getDouble("VisionOffsetD", 0.0);
	}

	//Autonomous
	
	public static double autoSwitchD1() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
			}
			return Preferences.getInstance().getDouble("AutoSwitchD1", 0.0);
	}

	public static double autoSwitchR1() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
			}
			return Preferences.getInstance().getDouble("AutoSwitchR1", 0.0);
	}

	public static double autoSwitchD2() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
			}
			return Preferences.getInstance().getDouble("AutoSwitchD2", 0.0);	
	}

	public static double autoSwitchR2() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
			}
			return Preferences.getInstance().getDouble("AutoSwitchR2", 0.0);	
	}

	public static double autoSwitchD3() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
			}
			return Preferences.getInstance().getDouble("AutoSwitchD3", 0.0);	
	}

}
