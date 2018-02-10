package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.RobotMap;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Collector extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX leftCollectorTalon = null;
	private WPI_TalonSRX rightCollectorTalon = null;
	private WPI_TalonSRX topLiftTalon = null;
	private WPI_TalonSRX bottomLiftTalon = null;
	private WPI_TalonSRX climbTalon = null; 
	
	private Encoder liftEncoder = null;
	
	private DigitalInput topSwitch = null;
	private DigitalInput bottomSwitch = null;
	private DigitalInput intakeSwitch = null;
	
	private DoubleSolenoid clampSolenoid = null;
	private DoubleSolenoid deploySolenoid = null;
	private DoubleSolenoid liftSolenoid = null;
	
	private DifferentialDrive differentialDrive = null;
	
	public Collector() {
		leftCollectorTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_INTAKE_LEFT_TALON);
		rightCollectorTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_INTAKE_RIGHT_TALON);
		topLiftTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_TOP_LIFT_TALON);
		bottomLiftTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_BOTTOM_LIFT_TALON);
		climbTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_CLIMB_TALON);
		
		leftCollectorTalon.setNeutralMode(NeutralMode.Brake);
		rightCollectorTalon.setNeutralMode(NeutralMode.Brake);
		topLiftTalon.setNeutralMode(NeutralMode.Brake);
		bottomLiftTalon.setNeutralMode(NeutralMode.Brake);
		climbTalon.setNeutralMode(NeutralMode.Brake);
		
		leftCollectorTalon.setSafetyEnabled(false);
		rightCollectorTalon.setSafetyEnabled(false);
		topLiftTalon.setSafetyEnabled(false);
		bottomLiftTalon.setSafetyEnabled(false);
		climbTalon.setSafetyEnabled(false);
		
		liftEncoder = new Encoder(RobotMap.COLLECTOR_ENCODER_A, RobotMap.COLLECTOR_ENCODER_B);
		
		topSwitch = new DigitalInput(RobotMap.COLLECTOR_TOP_SWITCH);
		bottomSwitch = new DigitalInput(RobotMap.COLLECTOR_BOTTOM_SWITCH);
		intakeSwitch = new DigitalInput(RobotMap.COLLECTOR_INTAKE_SWITCH);
		
		clampSolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_CLAMP_SOLENOID_CLAMP, RobotMap.COLLECTOR_CLAMP_SOLENOID_RELEASE);
		deploySolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_DEPLOY_SOLENOID_DEPLOY, RobotMap.COLLECTOR_DEPLOY_SOLENOID_RETRACT);
		liftSolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_LIFT_SOLENOID_A, RobotMap.COLLECTOR_LIFT_SOLENOID_B);
		
		differentialDrive = new DifferentialDrive(leftCollectorTalon, rightCollectorTalon);
		differentialDrive.setSafetyEnabled(false);
	}
	
	public void setClimberSpeed(double speed) {
		climbTalon.set(speed);
	}
	
	public void setCollectorSpeed(double speed) {
		leftCollectorTalon.set(speed);
		rightCollectorTalon.set(-speed);
	}
	
	public void setLiftSpeed(double speed) {
		if((speed > 0) && isTopSwitchClosed()) {
			speed = 0;
		}
		else if((speed < 0) && isBottomSwitchClosed()) {
			speed = 0;
		}
		
		topLiftTalon.set(speed);
		bottomLiftTalon.set(speed);
	}
	
	public double getEncoderCount() {
		return liftEncoder.get(); 
	}
	
	public double getEncoderDistance() {
		return liftEncoder.get() / RobotPreferences.collectorPulsesPerFoot();
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
	
	public boolean isCubeCollected() {
		return intakeSwitch.get();
	}
	
	public void clampCollector() {
		clampSolenoid.set(Value.kForward);
	}
	
	public void releaseCollector() {
		clampSolenoid.set(Value.kReverse);
	}
	
	public void deployCollector() {
		deploySolenoid.set(Value.kForward);
	}
	
	public void retractCollector() {
		deploySolenoid.set(Value.kReverse);
	}
	
	public void lockLift() {
		liftSolenoid.set(Value.kForward);
	}
	
	public void unlockLift() {
		liftSolenoid.set(Value.kReverse);
	}
	
	public void arcadeCollect(double moveSpeed, double rotateSpeed) {
		differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

