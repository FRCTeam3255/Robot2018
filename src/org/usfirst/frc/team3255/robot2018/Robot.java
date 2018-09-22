/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3255.robot2018;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3255.robot2018.commands.Autonomous;
import org.usfirst.frc.team3255.robot2018.subsystems.Collector;
import org.usfirst.frc.team3255.robot2018.subsystems.CollectorPID;
import org.usfirst.frc.team3255.robot2018.subsystems.Drivetrain;
import org.usfirst.frc.team3255.robot2018.subsystems.Lighting;
import org.usfirst.frc.team3255.robot2018.subsystems.DriveDistanceEncoderPID;
import org.usfirst.frc.team3255.robot2018.subsystems.NavYawPID;
import org.usfirst.frc.team3255.robot2018.subsystems.Navigation;
import org.usfirst.frc.team3255.robot2018.subsystems.Telemetry;
import org.usfirst.frc.team3255.robot2018.subsystems.DrivetrainDistanceVisionPID;
import org.usfirst.frc.team3255.robot2018.subsystems.CascadeLift;
import org.usfirst.frc.team3255.robot2018.subsystems.VisionOffsetPID;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public static Drivetrain drivetrain = null;
	public static Collector collector = null;
	public static Navigation navigation = null;
	public static CollectorPID collectorPID = null;
	public static DriveDistanceEncoderPID driveDistancePID = null;
	public static NavYawPID navYawPID = null;
	public static DrivetrainDistanceVisionPID drivetrainDistanceVisionPID = null;
	public static VisionOffsetPID visionOffsetPID = null;
	public static Lighting lighting = null;
	public static CascadeLift cascadeLift = null;
	public static Telemetry telemetry = null;
	public static OI oi;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain = new Drivetrain();
		collector = new Collector();
		navigation = new Navigation();
		collectorPID = new CollectorPID();
		driveDistancePID = new DriveDistanceEncoderPID();
		navYawPID = new NavYawPID();
		drivetrainDistanceVisionPID = new DrivetrainDistanceVisionPID();
		visionOffsetPID = new VisionOffsetPID();
		lighting = new Lighting();
		cascadeLift = new CascadeLift();
		telemetry = new Telemetry();
		oi = new OI();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		cascadeLift.shiftToCascade();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
			m_autonomousCommand = null;
		}
		lighting.setLighting(Lighting.DISABLED);
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		telemetry.update();
		navigation.updateVisionSettings();
		lighting.update();
		
		if(AutoPreferences.isReset()) {
			drivetrain.resetEncoder();
			cascadeLift.resetEncoder();
			navigation.resetYaw();
			navigation.resetPitch();
		}
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		telemetry.update();
		lighting.update();
//		m_autonomousCommand = m_chooser.getSelected();

		m_autonomousCommand = new Autonomous();

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		telemetry.update();
		lighting.update();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
			m_autonomousCommand = null;
		}
		lighting.update();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		telemetry.update();
		lighting.update();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
