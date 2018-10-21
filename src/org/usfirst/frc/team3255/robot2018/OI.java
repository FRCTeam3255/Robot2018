/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3255.robot2018;

import org.usfirst.frc.team3255.robot2018.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick driverStick = new Joystick(RobotMap.JOYSTICK_DRIVER);
	public Joystick manipulatorStick = new Joystick(RobotMap.JOYSTICK_MANIPULATOR);
	
	Button D1 = new JoystickButton(driverStick, 1);
	Button D5 = new JoystickButton(driverStick, 5);
	Button D6 = new JoystickButton(driverStick, 6);
	Button D7 = new JoystickButton(driverStick, 7);
	Button D8 = new JoystickButton(driverStick, 8);
	
	Button M1 = new JoystickButton(manipulatorStick, 1);
	Button M2 = new JoystickButton(manipulatorStick, 2);
	Button M3 = new JoystickButton(manipulatorStick, 3);
	Button M4 = new JoystickButton(manipulatorStick, 4);
	Button M5 = new JoystickButton(manipulatorStick, 5);
	Button M6 = new JoystickButton(manipulatorStick, 6);
	Button M7 = new JoystickButton(manipulatorStick, 7);
	Button M8 = new JoystickButton(manipulatorStick, 8);
	Button M9 = new JoystickButton(manipulatorStick, 9);
	Button M10 = new JoystickButton(manipulatorStick, 10);
	Button M11 = new JoystickButton(manipulatorStick, 11);
	Button M12 = new JoystickButton(manipulatorStick, 12);
	
	public OI() {		
		// Stick Manipulator
		M1.whileHeld(new CollectorEject());
		M2.whenPressed(new CollectorRelease());
		M2.whenReleased(new CollectorClamp());
		M3.whenPressed(new CollectorCollect());
		M4.whileHeld(new CascadeManualMove());
		M5.whenPressed(new CollectorCollectCube());	
		M6.whenPressed(new CollectorArmBack());
		
		// Top Row Manipulator
		M8.whenPressed(new CascacdeMoveToHighScale());
		M10.whileHeld(new CollectorClimberManual());
		M12.whenPressed(new CascadeMoveToLowScale());
		
		// Bottom Row Manipulator
//		M7.whenPressed(new CascadePrepClimber());
		M9.whenPressed(new CascadeSwitch());
		M11.whenPressed(new CascadeBottom());
		
		D5.whenPressed(new DrivetrainSlowSpeedEnable());
		D5.whenReleased(new DrivetrainSlowSpeedDisable());	
		D6.whenPressed(new DrivetrainSafetyDisable());
		D6.whenReleased(new DrivetrainSafetyEnable());
//		D5 multiply MoveSpeed and RotateSpeed by RobotPreferences.drivetrainSlowSpeed
		D7.whenPressed(new CollectorArmBack());
		D8.whenPressed(new CollectorArmFront());
	}
}
