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

	public static double distancePIDMinSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("DrivetrainPIDMinSpeed", 0.0);
	}
	
	public static double distancePIDMaxSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.5;
		}
		return Preferences.getInstance().getDouble("DrivetrainPIDMaxSpeed", 0.5);
	}
	
	public static double drivetrainP() {
		if(AutoPreferences.isDebug() == false) {
			return 0.15;
		}
		return Preferences.getInstance().getDouble("DrivetrainP", 0.15);
		//comp bot was 0.699
	}

	public static double drivetrainI() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("DrivetrainI", 0.0);
		//compbot was 0.019
	}

	public static double drivetrainD() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("DrivetrainD", 1.0);
		//0.9
	}

	public static int drivetrainTargetCount() {
		if(AutoPreferences.isDebug() == false) {
			return 2;
		}
		return Preferences.getInstance().getInt("DrivetrainTargetCount", 2);
	}
	
	public static double drivetrainTolerance() {
		if(AutoPreferences.isDebug() == false) {
			return 1.5;
		}
		return Preferences.getInstance().getDouble("DrivetrainTolerance", 1.5);
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
			return 90.0;
		}
		return  Preferences.getInstance().getDouble("DrivetrainClampMaxHeightMove", 100.0);
	}
	
	public static double drivetrainClampMaxHeightRotate() {
		if(AutoPreferences.isDebug() == false) {
			return 110.0;
		}
		return  Preferences.getInstance().getDouble("DrivetrainClampMaxHeightRotate", 100.0);
	}
	
	public static double drivetrainSlowSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.5;	
		}
		return  Preferences.getInstance().getDouble("DrivetrainSlowSpeed", 0.5);
	}
	
//	------------------------------------------------------------ CASCADE LIFT ------------------------------------------------------------
	public static double cascadeLiftP() {
		if(AutoPreferences.isDebug() == false) {
			return 0.2;
		}
		return Preferences.getInstance().getDouble("CascadeLiftP", 0.3);
	}

	public static double cascadeLiftI() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("CascadeLiftI", 0.0);
	}

	public static double cascadeLiftD() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("CascadeLiftD", 0.75);
	}
	
	public static double cascadeLiftPIDMin() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("CascadeLiftPIDMinSpeed", 0.0);
	}
	
	public static double cascadeLiftPIDMax() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CascadeLiftPIDMaxSpeed", 1.0);
	}
	
	public static double cascadeLiftDownMax() {
		if(AutoPreferences.isDebug() == false) {
			return 0.5;
		}
		return Preferences.getInstance().getDouble("CascadeLiftDownMaxSpeed", 0.75);
	}

	public static int cascadeLiftTargetCount() {
		if(AutoPreferences.isDebug() == false) {
			return 5;
		}
		return Preferences.getInstance().getInt("CascadeLiftTargetCount", 5);
	}

	public static double cascadeLiftTolerance() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		
		return Preferences.getInstance().getDouble("CascadeLiftTolerance", 1.0);
	}

	public static double cascadeLiftBottomSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("CascadeLiftBottomSetpoint", 0.0);
	}
	
	public static double cascadeLiftSwitchSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 24.0;
//			return 30.0;
		}
		return Preferences.getInstance().getDouble("CascadeLiftSwitchSetpoint", 30.0);
	}

	public static double cascadeLiftLowScaleSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 50.0;
		}
		return Preferences.getInstance().getDouble("CascadeLiftLowScaleSetpoint", 48.0);
	}

	public static double cascadeLiftHighScaleSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 60.0;
		}
		return Preferences.getInstance().getDouble("CascadeLiftHighScaleSetpoint", 60.0);
	}
	
	public static int cascadeLiftPulsesPerFoot() {
		if(AutoPreferences.isDebug() == false) {
			return 2750;
		}
		return Preferences.getInstance().getInt("CascadeLiftPulsesPerFoot", 333);
	}
	
	public static double cascadeLiftPIDMaxChange() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CascadeLiftPIDMaxChange", 1.0);
	}
	
//	-------------------------------------------------------------- COLLECTOR --------------------------------------------------------------
	public static double collectorMaxSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CollectorMaxSpeed", 1.0);
	}
	
	public static double collectorClimberSetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 45.0;
		}
		return Preferences.getInstance().getDouble("CollectorClimbSetpoint", 45.0);
	}
	
	public static double collectorCollectSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CollectorCollectSpeed", 1.0);
	}
	
	public static double collectorSlowEjectSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.5;
		}
		return Preferences.getInstance().getDouble("CollectorSlowEjectSpeed", 0.5);
	}
	
	public static int collectorCubeDelay() {
		if(AutoPreferences.isDebug() == false) {
			return 5;
		}
		return Preferences.getInstance().getInt("CollectorCubeDelay", 5);
	}
	
	public static double collectorDeploySetpoint() {
		if(AutoPreferences.isDebug() == false) {
			return 10.0;
		}
		return Preferences.getInstance().getDouble("CollectorDeploySetpoint", 10.0);
	}
	
	public static double collectorClimbExtendSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CollectorClimbExtendSpeed", 1.0);
	}
	
	public static double collectorArmScale() {
		if(AutoPreferences.isDebug() == false) {
//			return 285.0;
			return 251.4;		}
		return Preferences.getInstance().getDouble("CollectorArmScale", 1);
	}
	
	public static double collectorArmOffset() {
		if(AutoPreferences.isDebug() == false) {
//			return -132.0;
			return -2.0;
		}
		return Preferences.getInstance().getDouble("CollectorArmOffset", -132.0);
	}
	
	public static double collectorArmSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 0.60;
		}
		return Preferences.getInstance().getDouble("CollectorArmSpeed", 0.1);
	}
	
	public static double collectorArmFrontSpeed() {
		if(AutoPreferences.isDebug() == false) {
			return 1.0;
		}
		return Preferences.getInstance().getDouble("CollectorArmSpeed", 0.1);
	}
	
	public static double collectorArmBack() {
		if(AutoPreferences.isDebug() == false) {
			return 3.0;
//			return -84.0;
		}
		return Preferences.getInstance()
				.getDouble("CollectorArmBack", -90.0);
	}

	public static double collectorArmFront() {
		if(AutoPreferences.isDebug() == false) {
			return 25.0;
//			return -35.0;
		}
		return Preferences.getInstance().getDouble("CollectorArmFront", 0.0);
	}
	
	public static double collectorArmSafetyValue() {
		if(AutoPreferences.isDebug() == false) {
			return 90.0;
		}
		return Preferences.getInstance().getDouble("CollectorArmSafetyValue", 90.0);
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
			return 0.6;
		}
		return Preferences.getInstance().getDouble("YawPIDMax", 0.6);
		//0.6
	}

	public static double yawTolerance() {
		if(AutoPreferences.isDebug() == false) {
			return 1.5;
		}
		return Preferences.getInstance().getDouble("YawTolerance", 1.5);
	}

	public static double navYawP() {
		if(AutoPreferences.isDebug() == false) {
			return 0.1;
		}
		return Preferences.getInstance().getDouble("NavYawP", 0.1);
		//0.15
	}

	public static double navYawI() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
		}
		return Preferences.getInstance().getDouble("NavYawI", 0.0);
	}

	public static double navYawD() {
		if(AutoPreferences.isDebug() == false) {
			return 0.2;
		}
		return Preferences.getInstance().getDouble("NavYawD", 0.2);
		//0.0
	}
	
	public static int yawTargetCount() {
		if(AutoPreferences.isDebug() == false) {
			return 10;
		}
		return Preferences.getInstance().getInt("YawTargetCount", 10);
	}

//		-------------------------------------------------------------- VISION -------------------------------------------------------------- 
	public static int visionTargetCount() {
		if(AutoPreferences.isDebug() == false) {
			return 1;
		}
		return Preferences.getInstance().getInt("VisionTargetCount", 1);
	}
	
	public static boolean showRaw() {
		if(AutoPreferences.isDebug() == false) {
			return true;
		}
		return Preferences.getInstance().getBoolean("showRaw", true);
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
	
	public static double autoSwitchR3() {
		if(AutoPreferences.isDebug() == false) {
			return 0.0;
			}
		return Preferences.getInstance().getDouble("AutoSwitchR3", 0.0);
	}

	public static double timeOut() {
		if(AutoPreferences.isDebug() == false) {
//In seconds
			return 5.0;
		}
		return Preferences.getInstance().getDouble("TimeOut", 100.0);
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
		return Preferences.getInstance().getDouble("AutoExchangeR1", 100.0);
	}

	public static double autoExchangeR2() {
		if(AutoPreferences.isDebug() == false) {
			return 100.0;
		}
		return Preferences.getInstance().getDouble("AutoExchangeR2", 100.0);
	}
	
	public static double autoSwitchAfterScaleR1() {
		if(AutoPreferences.isDebug() == false) {
			return 10.0;
		}
		return Preferences.getInstance().getDouble("AutoSwitchAfterScaleR1", 10.0);
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

//		-------------------------------------------------------------- HSL VALUES -------------------------------------------------------------- 
	public static int lowHue() {
		if(AutoPreferences.isDebug() == false) {
			return 47;
		}
		return Preferences.getInstance().getInt("LowHue", 47);	
	}

	public static int highHue() {
		if(AutoPreferences.isDebug() == false) {
			return 75;
		}
		return Preferences.getInstance().getInt("HighHue", 75);	
	}

	public static int lowSat() {
		if(AutoPreferences.isDebug() == false) {
			return 112;
		}
		return Preferences.getInstance().getInt("LowSat", 112);	
	}

	public static int highSat() {
		if(AutoPreferences.isDebug() == false) {
			return 255;
		}
		return Preferences.getInstance().getInt("HighSat", 255);	
	}

	public static int lowLum() {
		if(AutoPreferences.isDebug() == false) {
			return 21;
		}
		return Preferences.getInstance().getInt("LowLum", 21);	
	}

	public static int highLum() {
		if(AutoPreferences.isDebug() == false) {
			return 112;
		}
		return Preferences.getInstance().getInt("HighLum", 112);
	}

	public static double moveToCubeDistance() {
		if(AutoPreferences.isDebug() == false) {
			return 12.0;
		}
		return Preferences.getInstance().getDouble("CubeDistance", 12.0);
	}
}
