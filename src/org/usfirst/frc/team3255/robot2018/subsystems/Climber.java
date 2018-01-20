package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.RobotMap;

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
	private WPI_TalonSRX leftClimbTalon = null;
	private WPI_TalonSRX rightClimbTalon = null;
	private WPI_TalonSRX leftLiftTalon = null;
	private WPI_TalonSRX rightLiftTalon = null;
	
	private DigitalInput topSwitch = null;
	
	private DoubleSolenoid climberSolenoid = null;
	
	public Climber() {
		leftClimbTalon = new WPI_TalonSRX(RobotMap.CLIMBER_LEFT_CLIMB_TALON);
		rightClimbTalon = new WPI_TalonSRX(RobotMap.CLIMBER_RIGHT_CLIMB_TALON);
		leftLiftTalon = new WPI_TalonSRX(RobotMap.CLIMBER_LEFT_LIFT_TALON);
		rightLiftTalon = new WPI_TalonSRX(RobotMap.CLIMBER_RIGHT_LIFT_TALON);
		
		climberSolenoid = new DoubleSolenoid(RobotMap.CLIMBER_SOLENOID_RETRACT, RobotMap.CLIMBER_SOLENOID_EXTEND);
		
		topSwitch = new DigitalInput(RobotMap.CLIMBER_TOP_SWITCH);
	}
	
	public void Climb() {
		leftClimbTalon.set(1.0);
		rightClimbTalon.set(1.0);
	}
	
	public void Lift() {
		leftLiftTalon.set(1.0);
		rightLiftTalon.set(1.0);
	}
	
	public void Retract() {
		climberSolenoid.set(Value.kReverse);
	}
	
	public void Extend() {
		climberSolenoid.set(Value.kForward);
	}
	
	public void ClimbStop() {
		leftClimbTalon.set(0.0);
		rightClimbTalon.set(0.0);
	}
	
	public boolean isTopSwitchClosed() {
		return !topSwitch.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

