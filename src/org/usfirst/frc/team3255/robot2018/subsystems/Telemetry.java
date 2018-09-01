package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.AutoPreferences;
import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {
	
	double maxPitch = 0;
	
	public Telemetry(){
		SmartDashboard.putData("Reset Drive Encoder", new DrivetrainResetEncoder());
		SmartDashboard.putData("Reset Collector Encoder", new CascadeResetEncoder());
		
		SmartDashboard.putData("Collector Front", new CollectorArmFront());
		SmartDashboard.putData("Collector Back", new CollectorArmBack());

		SmartDashboard.putData("Move to High Scale", new CascacdeMoveToHighScale());
		SmartDashboard.putData("Move to Low Scale", new CascadeMoveToLowScale());
		SmartDashboard.putData("Move to Switch", new CascadeMoveToSwitch());
		SmartDashboard.putData("Move to Bottom", new CascadeBottom());
		
		SmartDashboard.putData("Collector Dogtooth Unlock", new CascadeLiftUnlock());
		SmartDashboard.putData("Collector Dogtooth Lock", new CascadeLiftLock());
		
		SmartDashboard.putData("Reset Yaw", new NavResetYaw());
		SmartDashboard.putData("Reset Max Pitch", new NavResetMaxPitch());
		SmartDashboard.putData("Reset Pitch", new NavResetPitch());
		
		SmartDashboard.putString("Autonomous Status", "No Auto Running");

		SmartDashboard.putData("Drive 5 Feet", new DriveStraightDistance("Drive 5 Feet", 61.0));
		SmartDashboard.putData("Rotate 90", new DriveRotate("Rotate 90", 90.0));
		
		SmartDashboard.putData("Drive To Target", new DriveToTarget("Drive To Target", 30.0));
		SmartDashboard.putData("Drive to Cube", new VisionDriveCubeCollected("Drive To Cube"));
		
		SmartDashboard.putNumber("Default Lane", 2);
	}
	
	public void update() {
		SmartDashboard.putNumber("Drive Encoder Distance, Inches", Robot.drivetrain.getEncoderDistance());
		SmartDashboard.putNumber("Drive Encoder Count", Robot.drivetrain.getEncoderCount());
		SmartDashboard.putNumber("Get Drivetrain Speed", Robot.drivetrain.getSpeed());
		
		SmartDashboard.putNumber("Collector Encoder Count", Robot.cascadeLift.getEncoderCount());
		SmartDashboard.putNumber("Collector Encoder Distance", Robot.cascadeLift.getEncoderDistance());
		
		SmartDashboard.putBoolean("Cascade Is Top", Robot.cascadeLift.isCascadeTop());
		SmartDashboard.putBoolean("Cascade Is Bottom", Robot.cascadeLift.isCascadeBottom());
		SmartDashboard.putBoolean("Intake Is Top", Robot.cascadeLift.isIntakeTop());
		SmartDashboard.putBoolean("Is Cube Collected", Robot.collector.isCubeCollected());
		SmartDashboard.putBoolean("Arm Is Front", Robot.collector.isArmFront());
		SmartDashboard.putBoolean("Arm Is Back", Robot.collector.isArmBack());
		SmartDashboard.putNumber("Arm Position", Robot.collector.getArmPosition());
		SmartDashboard.putBoolean("Arm is Safe", Robot.collector.isArmSafe());
		
		SmartDashboard.putBoolean("Do Switch", AutoPreferences.doSwitch());
		SmartDashboard.putBoolean("Is Debug", AutoPreferences.isDebug());
		
		SmartDashboard.putBoolean("Red Alliance", Robot.navigation.isRedAlliance());
		
		SmartDashboard.putString("Alliance Switch Pos", String.valueOf(Robot.navigation.getAllianceSwitchPos()));
		SmartDashboard.putString("Alliance Scale Pos", String.valueOf(Robot.navigation.getScalePos()));
		SmartDashboard.putString("Opponent Switch Pos", String.valueOf(Robot.navigation.getOppenentSwitchPos()));
		
		SmartDashboard.putNumber("Nav Yaw", Robot.navigation.getYaw());
		SmartDashboard.putNumber("Nav Roll", Robot.navigation.getRoll());
		double pitch = Robot.navigation.getPitch();
		SmartDashboard.putNumber("Nav Pitch", pitch);

		SmartDashboard.putNumber("Vision Distance", Robot.navigation.getTargetDistance());
		SmartDashboard.putNumber("Vision Offset", Robot.navigation.getTargetOffset());
		SmartDashboard.putNumber("Vision Angle", Robot.navigation.getTargetAngle());
		SmartDashboard.putBoolean("Vision Target Found", Robot.navigation.isTargetFound());
		
		SmartDashboard.putNumber("CubeDistance", Robot.navigation.getCubeDistance());
		SmartDashboard.putNumber("CubeOffset", Robot.navigation.getCubeOffset());
		
		if(pitch > maxPitch) {
			maxPitch = pitch;
		}
		SmartDashboard.putNumber("Max Pitch", maxPitch);
		
		SmartDashboard.putNumber("Auto Switch D1", AutoPlaceSwitch.autoSwitchD1());
		SmartDashboard.putNumber("Auto Switch R1", AutoPlaceSwitch.autoSwitchR1());
		SmartDashboard.putNumber("Auto Switch D2", AutoPlaceSwitch.autoSwitchD2());
		SmartDashboard.putNumber("Auto Switch R2", AutoPlaceSwitch.autoSwitchR2());
		SmartDashboard.putNumber("Auto Switch D3", AutoPlaceSwitch.autoSwitchD3());
		
		SmartDashboard.putNumber("Lane", AutoPreferences.getLane());
	}
	
	public void resetMaxPitch() {
		maxPitch = 0;
	}
	
	public int getDefaultLane() {
		return (int) SmartDashboard.getNumber("Default Lane", 2);
	}
	
	public void setAutonomousStatus(String statusText) {
		SmartDashboard.putString("Autonomous Status", statusText);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
