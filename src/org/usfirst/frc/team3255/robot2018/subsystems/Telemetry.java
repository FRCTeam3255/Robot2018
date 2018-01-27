package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {
	/*
	public void Telemetry(){
	}
	*/
	public void update() {
		SmartDashboard.putNumber("Drive Encoder Distance", Robot.drivetrain.getEncoderDistance());
		SmartDashboard.putNumber("Drive Encoder Count", Robot.drivetrain.getEncoderCount());

		SmartDashboard.putNumber("Collector Encoder Count", Robot.collector.getEncoderCount());
		SmartDashboard.putNumber("Collector Encoder Distance", Robot.collector.getEncoderDistance());
		SmartDashboard.putBoolean("Is Cube Collected", Robot.collector.isCubeCollected());
		SmartDashboard.putBoolean("Collector Is Top", Robot.collector.isTopSwitchClosed());
		SmartDashboard.putBoolean("Collector Is Bottom", Robot.collector.isBottomSwitchClosed());
		
		SmartDashboard.putBoolean("Climber Top Switch", Robot.climber.isTopSwitchClosed());
		
		SmartDashboard.putString("Alliance Switch Pos", String.valueOf(Robot.navigation.getAllianceSwitchPos()));
		SmartDashboard.putString("Alliance Scale Pos", String.valueOf(Robot.navigation.getScalePos()));
		SmartDashboard.putString("Opponent Switch Pos", String.valueOf(Robot.navigation.getOppenentSwitchPos()));
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

