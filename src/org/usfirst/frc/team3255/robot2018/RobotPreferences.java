package org.usfirst.frc.team3255.robot2018;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

//	---------------------------------------------------------- DRIVETRAIN ----------------------------------------------------------
	public static double movePIDMaxChange() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("MovePIDMaxChange", 1.0);
	}

	public static double distancePIDMin() {
		if(AutoPreferences.isDebug() == false) {
			return 0.15;
		}
		return Preferences.getInstance().getDouble("DrivetrainPIDMinSpeed", 0.15);
	}
	
	public static double distancePIDMax() {
		if(AutoPreferences.isDebug() == false) {
			return 0.3;
		}
		return Preferences.getInstance().getDouble("DrivetrainPIDMaxSpeed", 0.3);
	}
	
	public static double drivetrainP() {
		if(AutoPreferences.isDebug() == false) {
			return 0.1;
		}
		return Preferences.getInstance().getDouble("DrivetrainP", 0.1);
	}

	public static double drivetrainI() {
		if(AutoPreferences.isDebug() == false) {
			return 0.001;
		}
		return Preferences.getInstance().getDouble("DrivetrainI", 0.001);
	}

	public static double drivetrainD() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("DrivetrainD", 1.0);
	}

	public static int drivetrainTargetCount() {
		if(AutoPreferences.isDebug() == false) {
			return 10;
		}
		return Preferences.getInstance().getInt("DrivetrainTargetCount", 10);
	}
	
	public static double drivetrainTolerance() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("DrivetrainTolerance", 0.0);
	}
	
	public static double drivetrainPulsePerFoot() {
		if(AutoPreferences.isDebug() == false) {
			return 164.0;
		}
		return Preferences.getInstance().getDouble("DrivetrainPulsePerFoot", 164.0);
	}
	
	public static double drivetrainMaxPitch() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
		}
		return Preferences.getInstance().getDouble("DrivetrainMaxPitch", 100.0);
	}
	
	public static double drivetrainClampMaxHeightMove() {
		if(AutoPreferences.isDebug() == false) {
			return 80.0;
		}
		return  Preferences.getInstance().getDouble("DrivetrainClampMaxHeightMove", 80.0);
	}
	
	public static double drivetrainClampMaxHeightRotate() {
		if(AutoPreferences.isDebug() == false) {
			return 92.0;
		}
		return  Preferences.getInstance().getDouble("DrivetrainClampMaxHeightRotate", 92.0);
	}
	
	public static double drivetrainSlowSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.75;	
		}
		return  Preferences.getInstance().getDouble("DrivetrainSlowSpeed", 0.75);
	}
	
//	------------------------------------------------------------ COLLECTOR ------------------------------------------------------------
	public static double collectorP() {
		if(AutoPreferences.isDebug() == false) {
			return 0.3;
		}
		return Preferences.getInstance().getDouble("CollectorP", 0.3);
	}

	public static double collectorI() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("CollectorI", 0.0);
	}

	public static double collectorD() {
		if(AutoPreferences.isDebug() == false) {
			return 0.75;
		}
		return Preferences.getInstance().getDouble("CollectorD", 0.75);
	}
	
	public static double collectorPIDMin() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("CollectorPIDMinSpeed", 0.0);
	}
	
	public static double collectorPIDMax() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CollectorPIDMaxSpeed", 1.0);
	}

	public static double collectorMaxSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CollectorMaxSpeed", 1.0);
	}

	public static int collectorTargetCount() {
		if(AutoPreferences.isDebug() == false) {
			return 5;
		}
		return Preferences.getInstance().getInt("CollectorTargetCount", 5);
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
			return 24.0;
		}
		return Preferences.getInstance().getDouble("CollectorSwitchSetpoint", 24.0);
	}

	public static double collectorLowScaleSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 40.0;
		}
		return Preferences.getInstance().getDouble("CollectorLowScaleSetpoint", 40.0);
	}

//	public static double collectorMedScaleSetpoint() {
//		if(AutoPreferences.isDebug() == false) {
//			return 30.0;
//		}
//		return Preferences.getInstance().getDouble("CollectorMedScaleSetpoint", 30.0);
//	}

	public static double collectorHighScaleSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 47.0;
		}
		return Preferences.getInstance().getDouble("CollectorHighScaleSetpoint", 47.0);
	}
	
	public static double collectorClimberSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 47.0;
		}
		return Preferences.getInstance().getDouble("CollectorClimbSetpoint", 47.0);
	}

	public static double collectorCollectSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CollectorCollectSpeed", 1.0);
	}

	public static double collectorEjectSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CollectorEjectSpeed", 1.0);
	}
	
	public static int collectorPulsesPerFoot() {
		if(AutoPreferences.isDebug() == false) {
			return 333;
		}
		return Preferences.getInstance().getInt("CollectorPulsesPerFoot", 333);
	}
	
	public static double collectorLiftMaxSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.25;
		}
		return Preferences.getInstance().getDouble("CollectorLiftMaxSpeed", 0.25);
	}
	
	public static int collectorCubeDelay() {
		if(AutoPreferences.isDebug() == false) {
			return 5;
		}
		return Preferences.getInstance().getInt("CollectorCubeDelay", 5);
	}

	
//	-------------------------------------------------------------- NAVIGATION ----------------------------------------------------------------
	public static double rotatePIDMaxChange() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("RotatePIDMaxChange", 1.0);
	}
	
	public static double yawPIDMin() {
		if(AutoPreferences.isDebug() == false) {
		return 0.0;
		}
		return Preferences.getInstance().getDouble("YawPIDMin", 0.0);
	}

	public static double yawPIDMax() {
		if(AutoPreferences.isDebug() == false) {
		return 1.0;
		}
		return Preferences.getInstance().getDouble("YawPIDMax", 1.0);
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

//		-------------------------------------------------------------- VISION -------------------------------------------------------------- 
	public static int visionTargetCount() {
		if(AutoPreferences.isDebug() == false) {
			return 1;
		}
		return Preferences.getInstance().getInt("VisionTargetCount", 1);
	}
//		-------------------------------------------------------------- VISION DISTANCE	-------------------------------------------------------------- 
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
	
	public static double visionDistanceTolerance() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("VisionDistanceTolerance", 1.0);
	}

//		-------------------------------------------------------------- VISION OFFSET -------------------------------------------------------------- 
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

	public static double visionOffsetTolerance() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("VisionOffsetTolerance", 1.0);
	}
	
//		-------------------------------------------------------------- LIGHTING	-------------------------------------------------------------- 
	public static double lightingFrequency() {
		if(AutoPreferences.isDebug() == false) {
			return -0.99;
		}
		return Preferences.getInstance().getDouble("LightingFrequency", -0.99);
	}
	
//		-------------------------------------------------------------- AUTONOMOUS -------------------------------------------------------------- 
	public static double autoSwitchD1() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
			}
		return Preferences.getInstance().getDouble("AutoSwitchD1", 0.0);
	}

	public static double autoSwitchR1() {
		if(AutoPreferences.isDebug() == false) {
			return 90.0;
			}
			
		return Preferences.getInstance().getDouble("AutoSwitchR1", 90.0);
	}

	public static double autoSwitchD2() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
			}
		return Preferences.getInstance().getDouble("AutoSwitchD2", 100.0);	
	}

	public static double autoSwitchR2() {
		if(AutoPreferences.isDebug() == false) {
			return -90.0;
			}
		return Preferences.getInstance().getDouble("AutoSwitchR2", -90.0);	
	}

	public static double autoSwitchD3() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
			}
		return Preferences.getInstance().getDouble("AutoSwitchD3", 100.0);	
	}

	public static double timeOut() {
		if(AutoPreferences.isDebug() == false) {
			return 5.0;
		}
		return Preferences.getInstance().getDouble("TimeOut", 5.0);
	}
	
	public static double autoScaleD1() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
			}
		return Preferences.getInstance().getDouble("AutoScaleD1", 100.0);
	}
	
	public static double autoScaleR1() {
		if(AutoPreferences.isDebug() == false) {
			return 90.0;
			}
		return Preferences.getInstance().getDouble("AutoScaleR1", 90.0);
	}

	public static double autoScaleD2() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
		}
		return Preferences.getInstance().getDouble("AutoScaleD2", 100.0);
	}

	public static double autoScaleR2() {
		if(AutoPreferences.isDebug() == false) {
			return 90.0;
		}
		return Preferences.getInstance().getDouble("AutoScaleR2", 90.0);
	}

	public static double autoScaleD3() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
		}
		return Preferences.getInstance().getDouble("AutoScaleD3", 100.0);
	}

	public static double autoExchangeD1() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
		}
		return Preferences.getInstance().getDouble("AutoExchangeD1", 100.0);
	}
	
	public static double autoExchangeD2() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
		}
		return Preferences.getInstance().getDouble("AutoExchangeD2", 100.0);
	}
	
	public static double autoExchangeD3() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
		}
		return Preferences.getInstance().getDouble("AutoExchangeD3", 100.0);
	}

	public static double autoExchangeR1() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
		}
		return Preferences.getInstance().getDouble("AutoExchangeR1", 90.0);
	}

	public static double autoExchangeR2() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
		}
		return Preferences.getInstance().getDouble("AutoExchangeR2", 90.0);
	}
	
	public static double autoSwitchAfterScaleR1() {
		if(AutoPreferences.isDebug() == false) {
			return 10.0;
		}
		return Preferences.getInstance().getDouble("AutoSwitchAfterScaleR1", 90.0);
	}

	public static double autoSwitchAfterScaleD1() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
		}
		return Preferences.getInstance().getDouble("AutoSwitchAfterScaleD1", 100.0);
	}
	
	public static double autoSwitchAfterScaleR2() {
		if(AutoPreferences.isDebug() == false) {
			return 90.0;
		}
		return Preferences.getInstance().getDouble("AutoSwitchAfterScaleR2", 90.0);
	}

	public static double autoSwitchAfterScaleD2() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
		}
		return Preferences.getInstance().getDouble("AutoSwitchAfterScaleD2", 100.0);
	}
	

	public static double autoSwitchAfterScaleD3() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
		}
		return Preferences.getInstance().getDouble("AutoSwitchAfterScaleD3", 100.0);
	}
	
	public static double collectorPIDMaxChange() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CollectorPIDMaxChange", 1.0);
	}

	public static double collectorDeploySetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 10.0;
		}
		return Preferences.getInstance().getDouble("CollectorDeploySetpoint", 10.0);
	}

//		-------------------------------------------------------------- HSL VALUES -------------------------------------------------------------- 
	public static int lowHue() {
		if(AutoPreferences.isDebug() == false) {
			return 45;
		}
		return Preferences.getInstance().getInt("LowHue", 45);	
	}

	public static int highHue() {
		if(AutoPreferences.isDebug() == false) {
			return 89;
		}
		return Preferences.getInstance().getInt("HighHue", 89);	
	}

	public static int lowSat() {
		if(AutoPreferences.isDebug() == false) {
			return 73;
		}
		return Preferences.getInstance().getInt("LowSat", 73);	
	}

	public static int highSat() {
		if(AutoPreferences.isDebug() == false) {
			return 207;
		}
		return Preferences.getInstance().getInt("HighSat", 207);	
	}

	public static int lowLum() {
		if(AutoPreferences.isDebug() == false) {
			return 73;
		}
		return Preferences.getInstance().getInt("LowLum", 73);	
	}

	public static int highLum() {
		if(AutoPreferences.isDebug() == false) {
			return 179;
		}
		return Preferences.getInstance().getInt("HighLum", 179);
	}

	public static boolean showRaw() {
		if(AutoPreferences.isDebug() == false) {
			return true;
		}
		return Preferences.getInstance().getBoolean("showRaw", true);
	}

	public static double climberExtendSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("ClimberExtendSpeed", 1.0);
	}
}
