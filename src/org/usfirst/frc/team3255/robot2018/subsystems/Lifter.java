package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.RobotMap;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

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
public class Lifter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX topLiftTalon = null;
	private WPI_TalonSRX bottomLiftTalon = null;
	
	private DigitalInput topSwitch = null;
	private DigitalInput bottomSwitch = null;
	
	private Encoder liftEncoder = null;
	
	private DoubleSolenoid liftSolenoid = null;
	
	public void Lift() {
		topLiftTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_TOP_LIFT_TALON);
		bottomLiftTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_BOTTOM_LIFT_TALON);
		
		topLiftTalon.setNeutralMode(NeutralMode.Brake);
		bottomLiftTalon.setNeutralMode(NeutralMode.Brake);
		
		topLiftTalon.setSafetyEnabled(false);
		bottomLiftTalon.setSafetyEnabled(false);
		
		liftEncoder = new Encoder(RobotMap.COLLECTOR_ENCODER_A, RobotMap.COLLECTOR_ENCODER_B);
		
		topSwitch = new DigitalInput(RobotMap.COLLECTOR_TOP_SWITCH);
		bottomSwitch = new DigitalInput(RobotMap.COLLECTOR_BOTTOM_SWITCH);
		
		liftSolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_LIFT_SOLENOID_A, RobotMap.COLLECTOR_LIFT_SOLENOID_B);
		
		
	}
	
	public void setLiftSpeed(double speed) {
		if((speed > 0) && isTopSwitchClosed()) {
			speed = 0;
//			liftSolenoid.set(Value.kReverse);
		}
		else if((speed < 0) && isBottomSwitchClosed()) {
			speed = 0;
		}
		
		double maxSpeed = RobotPreferences.collectorLiftMaxSpeed();
		
		if(speed < 0) {
			if (speed < -maxSpeed) {
				speed = -maxSpeed;
			}
		}
		
		topLiftTalon.set(speed);
		bottomLiftTalon.set(speed);
	}
	
	public double getEncoderCount() {
		return liftEncoder.get(); 
	}
	
	// returns lift encoder distance in inches
	public double getEncoderDistance() {
		return (liftEncoder.get() / (double) RobotPreferences.collectorPulsesPerFoot()) * 12;
	}
	
	public void resetEncoder() {
		liftEncoder.reset();
	}

	public boolean isTopSwitchClosed() {
		return topSwitch.get();
	}
	
	public boolean isBottomSwitchClosed() {
		return bottomSwitch.get();
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
//		Timer.delay(0.5);
		setLiftSpeed(0.0);
	}
	
	protected void setUnsafeSpeed(double speed) {
		topLiftTalon.set(speed);
		bottomLiftTalon.set(speed);
	}
	
	public double getCollectorHeight() {
		return getEncoderDistance();
	}
	
	public double getTalonCurrent() {
		return topLiftTalon.getOutputCurrent();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

