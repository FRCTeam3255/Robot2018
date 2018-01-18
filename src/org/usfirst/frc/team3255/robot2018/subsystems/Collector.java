package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX leftCollectorTalon = null;
	private WPI_TalonSRX rightCollectorTalon = null;
	private WPI_TalonSRX leftLiftTalon = null;
	private WPI_TalonSRX rightLiftTalon = null;
	
	private DigitalInput topSwitch = null;
	private DigitalInput bottomSwitch = null;
	
	public Collector() {
		leftCollectorTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_LEFT_TALON);
		rightCollectorTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_RIGHT_TALON);
		leftLiftTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_LEFT_LIFT_TALON);
		rightLiftTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_RIGHT_LIFT_TALON);
		
		topSwitch = new DigitalInput(RobotMap.COLLECTOR_TOP_SWITCH);
		bottomSwitch = new DigitalInput(RobotMap.COLLECTOR_BOTTOM_SWITCH);
		
		leftCollectorTalon.setSafetyEnabled(false);
		rightCollectorTalon.setSafetyEnabled(false);
		leftLiftTalon.setSafetyEnabled(false);
		rightLiftTalon.setSafetyEnabled(false);
		
		leftCollectorTalon.setNeutralMode(NeutralMode.Brake);
		rightCollectorTalon.setNeutralMode(NeutralMode.Brake);
		leftLiftTalon.setNeutralMode(NeutralMode.Brake);
		rightLiftTalon.setNeutralMode(NeutralMode.Brake);
	}
	
	public void collect() {
		leftCollectorTalon.set(1.0);
		rightCollectorTalon.set(-1.0);
	}
	
	public void eject() {
		leftCollectorTalon.set(-1.0);
		rightCollectorTalon.set(1.0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

