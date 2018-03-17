package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.RobotMap;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;
import org.usfirst.frc.team3255.robot2018.commands.CascadeCheckForBottom;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CascadeLift extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX topTalon = null;
	private WPI_TalonSRX midTalon = null;
	private WPI_TalonSRX bottomTalon = null;
	
	private DigitalInput topSwitch = null;
	private DigitalInput bottomSwitch = null;
	private DigitalInput bottomIntakeSwitch = null;
	
	private Encoder liftEncoder = null;
	
	private DoubleSolenoid liftSolenoid = null;
	private DoubleSolenoid climbShifterSolenoid = null;
	
	public CascadeLift() {
		topTalon = new WPI_TalonSRX(RobotMap.CASCADE_TOP_TALON);
		midTalon = new WPI_TalonSRX(RobotMap.CASCADE_MID_TALON);
		bottomTalon = new WPI_TalonSRX(RobotMap.CASCADE_BOTTOM_TALON);
		
		topTalon.setNeutralMode(NeutralMode.Brake);
		midTalon.setNeutralMode(NeutralMode.Brake);
		bottomTalon.setNeutralMode(NeutralMode.Brake);
		
		topTalon.setSafetyEnabled(false);
		midTalon.setSafetyEnabled(false);
		bottomTalon.setSafetyEnabled(false);
		
		liftEncoder = new Encoder(RobotMap.CASCADE_ENCODER_A, RobotMap.CASCADE_ENCODER_B);
		
		topSwitch = new DigitalInput(RobotMap.CASCADE_TOP_SWITCH);
		bottomSwitch = new DigitalInput(RobotMap.CASCADE_BOTTOM_SWITCH);
		bottomIntakeSwitch = new DigitalInput(RobotMap.CASCADE_BOTTOM_INTAKE_SWITCH);
		
		liftSolenoid = new DoubleSolenoid(RobotMap.CASCADE_LIFT_SOLENOID_A, RobotMap.CASCADE_LIFT_SOLENOID_B);
		climbShifterSolenoid = new DoubleSolenoid(RobotMap.CASCADE_CLIMB_SHIFTER_SOLENOID_A, RobotMap.CASCADE_CLIMB_SHIFTER_SOLENOID_B);
	}
	
	public void setClimberSpeed(double speed) {
		shiftToClimber();
		setLiftSpeed(speed);
	}
	
	public void setLiftSpeed(double speed) {
		if((speed > 0) && isTopSwitchClosed()) {
			speed = 0;
		}
		else if((speed < 0) && isBottomIntakeSwitchClosed()) {
			speed = 0;
		}
		
		topTalon.set(speed);
		midTalon.set(speed);
		bottomTalon.set(speed);
	}
	
	public double getEncoderCount() {
		return liftEncoder.get();
	}
	
	// returns lift encoder distance in inches
	public double getEncoderDistance() {
		return (liftEncoder.get() / (double) RobotPreferences.cascadeLiftPulsesPerFoot()) * 12;
	}
	
	public void resetEncoder() {
		liftEncoder.reset();
	}

	public boolean isTopSwitchClosed() {
		return !topSwitch.get();
	}
	
	public boolean isBottomSwitchClosed() {
		return !bottomSwitch.get();
	}
	
	public boolean isBottomIntakeSwitchClosed() {
		return bottomIntakeSwitch.get();
	}
	
	public void lockLift() {
		liftSolenoid.set(Value.kForward);
	}
	
	public void unlockLift() {
		liftSolenoid.set(Value.kReverse);
		if(!isBottomSwitchClosed()) {
			for(int i = 0; i <1000; i++) {
				setUnsafeSpeed(0.3);	
			}
		}
		setLiftSpeed(0.0);
	}
	
	public void shiftToClimber() {
		climbShifterSolenoid.set(Value.kForward);
	}
	
	public void shiftToCascade() {
		climbShifterSolenoid.set(Value.kReverse);
	}
	
	protected void setUnsafeSpeed(double speed) {
		topTalon.set(speed);
		midTalon.set(speed);
		bottomTalon.set(speed);
	}
	
	public double getCollectorHeight() {
		return getEncoderDistance();
	}
	
//	public double getTalonCurrent() {
//		return topTalon.getOutputCurrent();
//	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CascadeCheckForBottom());
    }
}