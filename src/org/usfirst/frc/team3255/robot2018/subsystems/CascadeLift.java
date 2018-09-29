package org.usfirst.frc.team3255.robot2018.subsystems;

//import org.usfirst.frc.team3255.robot2018.Robot;
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
	
	private DigitalInput topCascadeSwitch = null;
	private DigitalInput bottomCascadeSwitch = null;
	private DigitalInput topIntakeSwitch = null;
	
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
		
		topTalon.setInverted(true);
		midTalon.setInverted(true);
		bottomTalon.setInverted(true);
		
		liftEncoder = new Encoder(RobotMap.CASCADE_ENCODER_A, RobotMap.CASCADE_ENCODER_B);
		
		topCascadeSwitch = new DigitalInput(RobotMap.CASCADE_TOP_CASCADE_SWITCH);
		bottomCascadeSwitch = new DigitalInput(RobotMap.CASCADE_BOTTOM_CASCADE_SWITCH);
		topIntakeSwitch = new DigitalInput(RobotMap.CASCADE_TOP_INTAKE_SWITCH);
		
		liftSolenoid = new DoubleSolenoid(RobotMap.CASCADE_LIFT_SOLENOID_A, RobotMap.CASCADE_LIFT_SOLENOID_B);
		climbShifterSolenoid = new DoubleSolenoid(RobotMap.CASCADE_CLIMB_SHIFTER_SOLENOID_A, RobotMap.CASCADE_CLIMB_SHIFTER_SOLENOID_B);
	}
	
	public void setClimberSpeed(double speed) {
		shiftToClimber();
		setLiftSpeed(speed);
	}
	
	public void setLiftSpeed(double speed) {
		if(speed > 0) {
			if(isCascadeTop()) {
				speed = 0;
			}
//			else if(!isIntakeTop() && !Robot.collector.isArmSafe()) {
//				speed = 0;
//			}
		}
		
		else if(speed < 0) {
			if(isCascadeBottom()) {
				speed = 0;
				resetEncoder();
			}
//			else if(!Robot.collector.isArmSafe() && isCascadeBottom()) {
//				speed = 0;
//			}
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

	public boolean isCascadeTop() {
		return !topCascadeSwitch.get();
	}
	
	public boolean isIntakeTop() {
		return !topIntakeSwitch.get();
	}
	
	public boolean isCascadeBottom() {
		return !bottomCascadeSwitch.get();
	}
	
	public void lockLift() {
		liftSolenoid.set(Value.kForward);
	}
	
	public void unlockLift() {
		liftSolenoid.set(Value.kReverse);
		if(!isCascadeBottom()) {
			for(int i = 0; i <1000; i++) {
				setUnsafeSpeed(0.3);	
			}
		}
		setLiftSpeed(0.0);
	}
	
	public void shiftToClimber() {
		climbShifterSolenoid.set(Value.kReverse);
	}
	
	public void shiftToCascade() {
		climbShifterSolenoid.set(Value.kForward);
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