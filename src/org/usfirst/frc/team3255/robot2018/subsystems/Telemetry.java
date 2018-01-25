package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {
	
	//public void Telemetry(){
	//}
	
	public void update() {
		SmartDashboard.putNumber("Left Encoder Count", Robot.drivetrain.getLeftEncoderCount());
		SmartDashboard.putNumber("Right Encoder Count", Robot.drivetrain.getRightEncoderCount());
		SmartDashboard.putNumber("Collector Encoder Count", Robot.collector.getEncoderCount());
		SmartDashboard.putBoolean("Is Cube Collected", Robot.collector.isCubeCollected());
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

