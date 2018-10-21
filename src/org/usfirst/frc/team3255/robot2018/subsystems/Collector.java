package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotMap;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Collector extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX leftCollectorTalon = null;
	private WPI_TalonSRX rightCollectorTalon = null; 
	private WPI_TalonSRX armTalon = null;
	
	private DigitalInput cubeIntakeSwitch = null;

	private DoubleSolenoid clampSolenoid = null;
	
	private Potentiometer armPot = null;

	private DifferentialDrive collectorDrive = null;
	
	public Collector() {
		leftCollectorTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_INTAKE_LEFT_TALON);
		rightCollectorTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_INTAKE_RIGHT_TALON);
		armTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_ARM_TALON);
		
		leftCollectorTalon.setNeutralMode(NeutralMode.Brake);
		rightCollectorTalon.setNeutralMode(NeutralMode.Brake);
		armTalon.setNeutralMode(NeutralMode.Brake);
		
		leftCollectorTalon.setSafetyEnabled(false);
		rightCollectorTalon.setSafetyEnabled(false);
		armTalon.setSafetyEnabled(false);
		
//		armTalon.setInverted(true);
		
		cubeIntakeSwitch = new DigitalInput(RobotMap.COLLECTOR_CUBE_INTAKE_SWITCH);
		
		clampSolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_CLAMP_SOLENOID_CLAMP, RobotMap.COLLECTOR_CLAMP_SOLENOID_RELEASE);
		
		armPot = new AnalogPotentiometer(RobotMap.COLLECTOR_ARM_POT, RobotPreferences.collectorArmScale(), RobotPreferences.collectorArmOffset());
		
		collectorDrive = new DifferentialDrive(leftCollectorTalon, rightCollectorTalon);
		collectorDrive.setSafetyEnabled(false);
	}
	
	public void setCollectorSpeed(double speed) {
		leftCollectorTalon.set(speed);
		rightCollectorTalon.set(-speed);
	}
	
	public void setArmSpeed(double speed) {
//		if((speed > 0) && isArmFront()) {
//			speed = 0;
//		}
//		else if((speed < 0) && isArmBack()) {
//			speed = 0;
//		}
//		
		armTalon.set(speed);
	}
	
	public boolean isCubeCollected() {
		return !cubeIntakeSwitch.get();
	}
	
	public boolean isArmBack() {
		return getArmPosition() <= RobotPreferences.collectorArmBack(); 
	}
	
	public boolean isArmFront() {
		return getArmPosition() >= RobotPreferences.collectorArmFront();
	}
	
	public double getArmPosition() {
		return armPot.get();
	}
	
	public boolean isArmSafe() {
		return Robot.collector.getArmPosition() > RobotPreferences.collectorArmSafetyValue();
	}
	
	public void clampCollector() {
		clampSolenoid.set(Value.kForward);
	}
	
	public void releaseCollector() {
		clampSolenoid.set(Value.kReverse);
	}
	
	public void arcadeCollect(double moveSpeed, double rotateSpeed) {
		collectorDrive.arcadeDrive(moveSpeed, rotateSpeed);
	}
	
//	public double getTalonCurrent() {
//		return leftCollectorTalon.getOutputCurrent();
//	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

