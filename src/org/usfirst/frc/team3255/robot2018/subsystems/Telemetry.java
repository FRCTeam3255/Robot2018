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
		SmartDashboard.putNumber("Avg Encoder Distance", Robot.drivetrain.getAverageEncoderDistance());
		SmartDashboard.putNumber("Right Encoder Count", Robot.drivetrain.getRightEncoderCount());
		SmartDashboard.putNumber("Left Encoder Count", Robot.drivetrain.getLeftEncoderCount());
		SmartDashboard.putNumber("Right Encoder Distance", Robot.drivetrain.getRightEncoderDistance());
		SmartDashboard.putNumber("Left Encoder Distance", Robot.drivetrain.getLeftEncoderDistance());

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

