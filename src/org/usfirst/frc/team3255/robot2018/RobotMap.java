/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3255.robot2018;

import edu.wpi.first.wpilibj.DigitalSource;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int DRIVETRAIN_LEFT_FRONT_TALON = 1;
	public static final int DRIVETRAIN_LEFT_BACK_TALON = 2;
	public static final int DRIVETRAIN_RIGHT_FRONT_TALON = 3;
	public static final int DRIVETRAIN_RIGHT_BACK_TALON = 4;
	
	public static final int JOYSTICK_DRIVER = 0;
	
	public static final int DRIVER_MOVE_AXIS = 1;
	public static final int DRIVER_ROTATE_AXIS = 2;
	
	public static final int DRIVETRAIN_LEFT_ENCODER_A = 1;
	public static final int DRIVETRAIN_LEFT_ENCODER_B = 2;
	public static final int DRIVETRAIN_RIGHT_ENCODER_A = 3;
	public static final int DRIVETRAIN_RIGHT_ENCODER_B = 4;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
