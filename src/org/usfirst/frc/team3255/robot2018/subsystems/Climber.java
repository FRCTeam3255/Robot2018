package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.RobotMap;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX leftTalon = null;
	private WPI_TalonSRX rightTalon = null;
	
	private DigitalInput topSwitch = null;
	private DigitalInput bottomSwitch = null;
	
	private DoubleSolenoid climberSolenoid = null;
	
	public Climber() {
		leftTalon = new WPI_TalonSRX(RobotMap.CLIMBER_LEFT_TALON);
		rightTalon = new WPI_TalonSRX(RobotMap.CLIMBER_RIGHT_TALON);

		leftTalon.setNeutralMode(NeutralMode.Brake);
		rightTalon.setNeutralMode(NeutralMode.Brake);

		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);

		climberSolenoid = new DoubleSolenoid(RobotMap.CLIMBER_SOLENOID_RETRACT, RobotMap.CLIMBER_SOLENOID_EXTEND);
		
		topSwitch = new DigitalInput(RobotMap.CLIMBER_TOP_SWITCH);
		bottomSwitch = new DigitalInput(RobotMap.CLIMBER_BOTTOM_SWITCH);
	}

	//Cascade
	public void extend() {
		double speed = RobotPreferences.climberExtendSpeed();
		
		leftTalon.set(speed);
		rightTalon.set(speed);
	}
	
	public void retract() {
		double speed = RobotPreferences.climberRetractSpeed();
		
		leftTalon.set(speed);
		rightTalon.set(speed);
	}
	
	public void stop() {
		leftTalon.set(0.0);
		rightTalon.set(0.0);
	}
	
	//Triple Threat
	public void rungRetract() {
		climberSolenoid.set(Value.kReverse);
	}
	
	public void rungExtend() {
		climberSolenoid.set(Value.kForward);
	}
	
	public boolean isTopSwitchClosed() {
		return !topSwitch.get();
	}
	
	public boolean isBottomSwitchClosed() {
		return !bottomSwitch.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

