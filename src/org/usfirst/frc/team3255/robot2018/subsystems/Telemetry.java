package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.AutoPreferences;
import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.commands.CollectorDeploy;
import org.usfirst.frc.team3255.robot2018.commands.CollectorMoveToBottom;
import org.usfirst.frc.team3255.robot2018.commands.CollectorMoveToHighScale;
import org.usfirst.frc.team3255.robot2018.commands.CollectorMoveToLowScale;
import org.usfirst.frc.team3255.robot2018.commands.CollectorMoveToMedScale;
import org.usfirst.frc.team3255.robot2018.commands.CollectorMoveToSwitch;
import org.usfirst.frc.team3255.robot2018.commands.CollectorResetEncoder;
import org.usfirst.frc.team3255.robot2018.commands.CollectorRetract;
import org.usfirst.frc.team3255.robot2018.commands.DriveDistance;
import org.usfirst.frc.team3255.robot2018.commands.DriveRotate;
import org.usfirst.frc.team3255.robot2018.commands.DriveToTarget;
import org.usfirst.frc.team3255.robot2018.commands.DrivetrainResetEncoder;
import org.usfirst.frc.team3255.robot2018.commands.NavResetMaxPitch;
import org.usfirst.frc.team3255.robot2018.commands.NavResetPitch;
import org.usfirst.frc.team3255.robot2018.commands.NavResetYaw;

import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.hal.PDPJNI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {
	
	double maxPitch = 0;
	
	public Telemetry(){
		SmartDashboard.putData("Reset Drive Encoder", new DrivetrainResetEncoder());
		SmartDashboard.putData("Reset Collector Encoder", new CollectorResetEncoder());
		
		SmartDashboard.putData("Retract Collector", new CollectorRetract());
		SmartDashboard.putData("Deploy Collector", new CollectorDeploy());
		
		SmartDashboard.putData("Move to High Scale", new CollectorMoveToHighScale());
		SmartDashboard.putData("Move to Med Scale", new CollectorMoveToMedScale());
		SmartDashboard.putData("Move to Low Scale", new CollectorMoveToLowScale());
		SmartDashboard.putData("Move to Switch", new CollectorMoveToSwitch());
		SmartDashboard.putData("Move to Bottom", new CollectorMoveToBottom());
		
		SmartDashboard.putData("Reset Yaw", new NavResetYaw());
		SmartDashboard.putData("Reset Max Pitch", new NavResetMaxPitch());
		SmartDashboard.putData("Reset Pitch", new NavResetPitch());
		
		SmartDashboard.putString("Autonomous Status", "No Auto Running");

		SmartDashboard.putData("Drive 5 Feet", new DriveDistance("Drive 5 Feet", 60.0));
		SmartDashboard.putData("Drive To Target", new DriveToTarget("Drive To Target", 15.0));
		SmartDashboard.putData("Rotate 90", new DriveRotate("Rotate 90", 90.0));
	}
	
	public void update() {
		SmartDashboard.putNumber("Drive Encoder Distance, Inches", Robot.drivetrain.getEncoderDistance());
		SmartDashboard.putNumber("Drive Encoder Count", Robot.drivetrain.getEncoderCount());
		
		SmartDashboard.putNumber("Drive to Target Distance", Robot.navigation.getTargetDistance());

		SmartDashboard.putNumber("Collector Encoder Count", Robot.collector.getEncoderCount());
		SmartDashboard.putNumber("Collector Encoder Distance", Robot.collector.getEncoderDistance());
		
		SmartDashboard.putBoolean("Is Cube Collected", Robot.collector.isCubeCollected());
		SmartDashboard.putBoolean("Collector Is Top", Robot.collector.isTopSwitchClosed());
		SmartDashboard.putBoolean("Collector Is Bottom", Robot.collector.isBottomSwitchClosed());
		
		SmartDashboard.putBoolean("Red Alliance", Robot.navigation.isRedAlliance());
		
		SmartDashboard.putString("Alliance Switch Pos", String.valueOf(Robot.navigation.getAllianceSwitchPos()));
		SmartDashboard.putString("Alliance Scale Pos", String.valueOf(Robot.navigation.getScalePos()));
		SmartDashboard.putString("Opponent Switch Pos", String.valueOf(Robot.navigation.getOppenentSwitchPos()));
		
		SmartDashboard.putBoolean("Is Debug", AutoPreferences.isDebug());
		
//		SmartDashboard.putNumber("PDP Channel Current", PDPJNI.getPDPChannelCurrent((byte) 0, 0));
		
		SmartDashboard.putNumber("Vision Distance", Robot.navigation.getTargetDistance());
		SmartDashboard.putNumber("Vision Offset", Robot.navigation.getTargetOffset());
		SmartDashboard.putNumber("Vision Angle", Robot.navigation.getTargetAngle());
		SmartDashboard.putBoolean("Vision Target Found", Robot.navigation.isTargetFound());
		
		SmartDashboard.putNumber("Nav Yaw", Robot.navigation.getYaw());
		SmartDashboard.putNumber("Nav Roll", Robot.navigation.getRoll());
		
		double pitch = Robot.navigation.getPitch();
		SmartDashboard.putNumber("Nav Pitch", pitch);
		
		if(pitch > maxPitch) {
			maxPitch = pitch;
		}
		SmartDashboard.putNumber("Max Pitch", maxPitch);
		
		SmartDashboard.putBoolean("Do Switch", AutoPreferences.doSwitch());
		
		SmartDashboard.putNumber("Get Drivetrain Speed", Robot.drivetrain.getSpeed());
	}
	
	public void resetMaxPitch() {
		maxPitch = 0;
	}
	
	public void setAutonomousStatus(String statusText) {
		SmartDashboard.putString("Autonomous Status", statusText);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

