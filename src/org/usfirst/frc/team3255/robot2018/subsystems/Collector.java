package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.AutoPreferences;
import org.usfirst.frc.team3255.robot2018.RobotMap;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
	private WPI_TalonSRX climbTalon = null; 
	
	private DigitalInput intakeSwitch = null;
	
	private DoubleSolenoid clampSolenoid = null;
	private DoubleSolenoid deploySolenoid = null;

	private DifferentialDrive collectorDrive = null;
	
	public Collector() {
		leftCollectorTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_INTAKE_LEFT_TALON);
		rightCollectorTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_INTAKE_RIGHT_TALON);
		climbTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_CLIMB_TALON);
		
		leftCollectorTalon.setInverted(true);
		rightCollectorTalon.setInverted(true);	
		
		leftCollectorTalon.setNeutralMode(NeutralMode.Brake);
		rightCollectorTalon.setNeutralMode(NeutralMode.Brake);
		climbTalon.setNeutralMode(NeutralMode.Brake);
		
		leftCollectorTalon.setSafetyEnabled(false);
		rightCollectorTalon.setSafetyEnabled(false);
		climbTalon.setSafetyEnabled(false);
		
		intakeSwitch = new DigitalInput(RobotMap.COLLECTOR_INTAKE_SWITCH);
		
		clampSolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_CLAMP_SOLENOID_CLAMP, RobotMap.COLLECTOR_CLAMP_SOLENOID_RELEASE);
		deploySolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_DEPLOY_SOLENOID_DEPLOY, RobotMap.COLLECTOR_DEPLOY_SOLENOID_RETRACT);

		
		collectorDrive = new DifferentialDrive(leftCollectorTalon, rightCollectorTalon);
		collectorDrive.setSafetyEnabled(false);
	}
	
	public void setClimberSpeed(double speed) {
		if(!AutoPreferences.isDebug()) {
			if(speed < 0) {
				speed = 0;
			}
		}
		climbTalon.set(speed);
	}
	
	public void setCollectorSpeed(double speed) {
		leftCollectorTalon.set(speed);
		rightCollectorTalon.set(-speed);
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

