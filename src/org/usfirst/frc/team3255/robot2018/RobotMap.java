/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3255.robot2018;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//Talons
	public static final int DRIVETRAIN_LEFT_FRONT_TALON = 1;
	public static final int DRIVETRAIN_LEFT_BACK_TALON = 2;
	public static final int DRIVETRAIN_RIGHT_FRONT_TALON = 3;
	public static final int DRIVETRAIN_RIGHT_BACK_TALON = 4;	
	
	public static final int COLLECTOR_INTAKE_RIGHT_TALON = 5;
	public static final int COLLECTOR_INTAKE_LEFT_TALON = 6;
	public static final int COLLECTOR_ARM_TALON = 7;
	
	public static final int CASCADE_TOP_TALON = 8;
	public static final int CASCADE_MID_TALON = 9;
	public static final int CASCADE_BOTTOM_TALON = 10;

	
	//Lighting
	public static final int LIGHTING_STATUSLIGHTING = 0;
	
	//Joysticks
	public static final int JOYSTICK_DRIVER = 0;
	public static final int JOYSTICK_MANIPULATOR = 1;
	public static final int JOYSTICK_PREFERENCES = 2;
	
	public static final int DRIVER_MOVE_AXIS = 1;
	public static final int DRIVER_ROTATE_AXIS = 2;
	
	public static final int COLLECTOR_MOVE_AXIS = 1;
	public static final int COLLECTOR_ROTATE_AXIS = 0;
	public static final int COLLECTOR_SPEED_AXIS = 3;
	
	//Encoder
	public static final int DRIVETRAIN_ENCODER_A = 0;
	public static final int DRIVETRAIN_ENCODER_B = 1;
		
	public static final int CASCADE_ENCODER_A = 2;
	public static final int CASCADE_ENCODER_B = 3;
		
	//Switches
	public static final int CASCADE_TOP_CASCADE_SWITCH = 4;
	public static final int CASCADE_BOTTOM_CASCADE_SWITCH = 5;
	public static final int CASCADE_TOP_INTAKE_SWITCH = 6;
	public static final int COLLECTOR_CUBE_INTAKE_SWITCH = 7;
	
	//Pots
	public static final int COLLECTOR_ARM_POT = 0;
	
	//Solenoid
	public static final int COLLECTOR_CLAMP_SOLENOID_CLAMP = 0;
	public static final int COLLECTOR_CLAMP_SOLENOID_RELEASE = 1;
	public static final int CASCADE_CLIMB_SHIFTER_SOLENOID_A = 2;
	public static final int CASCADE_CLIMB_SHIFTER_SOLENOID_B = 3;
	public static final int CASCADE_LIFT_SOLENOID_A = 4;
	public static final int CASCADE_LIFT_SOLENOID_B = 5;
}
