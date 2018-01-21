/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3255.robot2018;

import org.usfirst.frc.team3255.robot2018.commands.ClimberClimb;
import org.usfirst.frc.team3255.robot2018.commands.ClimberExtend;
import org.usfirst.frc.team3255.robot2018.commands.ClimberRetract;
import org.usfirst.frc.team3255.robot2018.commands.ClimberStop;
import org.usfirst.frc.team3255.robot2018.commands.CollectorCollect;
import org.usfirst.frc.team3255.robot2018.commands.CollectorEject;
import org.usfirst.frc.team3255.robot2018.commands.CollectorStopCollecting;

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
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
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
		M1.whenPressed(new CollectorEject());
		M2.whenPressed(new CollectorCollect());
		M3.whenPressed(new CollectorStopCollecting());
		M11.whenPressed(new ClimberClimb());
		M9.whenPressed(new ClimberRetract());
		M10.whenPressed(new ClimberExtend());
		M7.whenPressed(new ClimberStop());
	}
}
