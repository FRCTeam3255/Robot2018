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
import org.usfirst.frc.team3255.robot2018.commands.DrivetrainResetEncoder;
import org.usfirst.frc.team3255.robot2018.commands.NavResetVisionDistance;
import org.usfirst.frc.team3255.robot2018.commands.NavResetVisionOffset;
import org.usfirst.frc.team3255.robot2018.commands.NavResetYaw;

import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.hal.PDPJNI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {
	
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
		SmartDashboard.putData("Reset Vision Distance", new NavResetVisionDistance());
		SmartDashboard.putData("Reset Vision Distance", new NavResetVisionOffset());
		
		SmartDashboard.putString("Autonomous Status", "No Auto Running");
	}
	
	public void update() {
		SmartDashboard.putNumber("Drive Encoder Distance, Inches", Robot.drivetrain.getEncoderDistance());
		SmartDashboard.putNumber("Drive Encoder Count", Robot.drivetrain.getEncoderCount());

		SmartDashboard.putNumber("Collector Encoder Count", Robot.collector.getEncoderCount());
		SmartDashboard.putNumber("Collector Encoder Distance", Robot.collector.getEncoderDistance());
		
		SmartDashboard.putBoolean("Is Cube Collected", Robot.collector.isCubeCollected());
		SmartDashboard.putBoolean("Collector Is Top", Robot.collector.isTopSwitchClosed());
		SmartDashboard.putBoolean("Collector Is Bottom", Robot.collector.isBottomSwitchClosed());
		
		SmartDashboard.putBoolean("Climber Top Switch", Robot.climber.isTopSwitchClosed());
		SmartDashboard.putBoolean("Climber Bottom Switch", Robot.climber.isBottomSwitchClosed());
		
		SmartDashboard.putBoolean("Red Alliance", AutoPreferences.isRedAlliance());
		
		SmartDashboard.putString("Alliance Switch Pos", String.valueOf(Robot.navigation.getAllianceSwitchPos()));
		SmartDashboard.putString("Alliance Scale Pos", String.valueOf(Robot.navigation.getScalePos()));
		SmartDashboard.putString("Opponent Switch Pos", String.valueOf(Robot.navigation.getOppenentSwitchPos()));
		
		SmartDashboard.putBoolean("Is Debug", AutoPreferences.isDebug());
		
//		SmartDashboard.putNumber("PDP Channel Current", PDPJNI.getPDPChannelCurrent((byte) 0, 0));
		
		SmartDashboard.putNumber("Vision Distance", Robot.navigation.getTargetDistance());
		SmartDashboard.putNumber("Vision Offset", Robot.navigation.getTargetOffset());
		SmartDashboard.putNumber("Vision Angle", Robot.navigation.getTargetAngle());
		
		SmartDashboard.putNumber("Nav Yaw", Robot.navigation.getYaw());
		SmartDashboard.putNumber("Nav Pitch", Robot.navigation.getPitch());

		
		SmartDashboard.putBoolean("Do Switch", AutoPreferences.doSwitch());
	}
	
	public void setAutonomousStatus(String statusText) {
		SmartDashboard.putString("Autonomous Status", statusText);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

