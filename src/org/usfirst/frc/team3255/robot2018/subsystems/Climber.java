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
	private WPI_TalonSRX leftWinchTalon = null;
	private WPI_TalonSRX rightWinchTalon = null;
	private WPI_TalonSRX leftCascadeTalon = null;
	private WPI_TalonSRX rightCascadeTalon = null;
	
	private DigitalInput topSwitch = null;
	
	private DoubleSolenoid climberSolenoid = null;
	
	public Climber() {
		leftWinchTalon = new WPI_TalonSRX(RobotMap.CLIMBER_LEFT_WINCH_TALON);
		rightWinchTalon = new WPI_TalonSRX(RobotMap.CLIMBER_RIGHT_WINCH_TALON);
		leftCascadeTalon = new WPI_TalonSRX(RobotMap.CLIMBER_LEFT_CASCADE_TALON);
		rightCascadeTalon = new WPI_TalonSRX(RobotMap.CLIMBER_RIGHT_CASCADE_TALON);
		
		climberSolenoid = new DoubleSolenoid(RobotMap.CLIMBER_SOLENOID_RETRACT, RobotMap.CLIMBER_SOLENOID_EXTEND);
		
		topSwitch = new DigitalInput(RobotMap.CLIMBER_TOP_SWITCH);
	}
	
	// Winch
	public void robotClimb() {
		leftWinchTalon.set(1.0);
		rightWinchTalon.set(1.0);
	}
	
	// Cascade Lift
	public void cascadeLift() {
		leftCascadeTalon.set(1.0);
		rightCascadeTalon.set(1.0);
	}
	
	//Triple Threat
	public void rungRetract() {
		climberSolenoid.set(Value.kReverse);
	}
	
	public void rungExtend() {
		climberSolenoid.set(Value.kForward);
	}
	
	public void climbStop() {
		leftWinchTalon.set(0.0);
		rightWinchTalon.set(0.0);
	}
	
	public boolean isTopSwitchClosed() {
		return !topSwitch.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

