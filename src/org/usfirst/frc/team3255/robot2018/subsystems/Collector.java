package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotMap;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;
import org.usfirst.frc.team3255.robot2018.commands.CollectorArcade;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
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
	private WPI_TalonSRX leftLiftTalon = null;
	private WPI_TalonSRX rightLiftTalon = null;
	
	private Encoder encoder = null;
	
	private DigitalInput topSwitch = null;
	private DigitalInput bottomSwitch = null;
	private DigitalInput intakeSwitch = null;
	
	private DifferentialDrive differentialDrive = null;
	
	public Collector() {
		leftCollectorTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_LEFT_TALON);
		rightCollectorTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_RIGHT_TALON);
		leftLiftTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_LEFT_LIFT_TALON);
		rightLiftTalon = new WPI_TalonSRX(RobotMap.COLLECTOR_RIGHT_LIFT_TALON);
		
		encoder = new Encoder(RobotMap.COLLECTOR_ENCODER_A, RobotMap.COLLECTOR_ENCODER_B);
		
		topSwitch = new DigitalInput(RobotMap.COLLECTOR_TOP_SWITCH);
		bottomSwitch = new DigitalInput(RobotMap.COLLECTOR_BOTTOM_SWITCH);
		intakeSwitch = new DigitalInput(RobotMap.COLLECTOR_INTAKE_SWITCH);
		
		leftCollectorTalon.setSafetyEnabled(false);
		rightCollectorTalon.setSafetyEnabled(false);
		leftLiftTalon.setSafetyEnabled(false);
		rightLiftTalon.setSafetyEnabled(false);
		
		leftCollectorTalon.setNeutralMode(NeutralMode.Brake);
		rightCollectorTalon.setNeutralMode(NeutralMode.Brake);
		leftLiftTalon.setNeutralMode(NeutralMode.Brake);
		rightLiftTalon.setNeutralMode(NeutralMode.Brake);
		
		differentialDrive = new DifferentialDrive(leftCollectorTalon, rightCollectorTalon);
	}
	
	public void collect() {
		leftCollectorTalon.set(0.5);
		rightCollectorTalon.set(-0.5);
	}
	
	public void collectorStop() {
		leftCollectorTalon.set(0.0);
		rightCollectorTalon.set(0.0);
	}
	
	public void eject() {
		leftCollectorTalon.set(-1.0);
		rightCollectorTalon.set(1.0);
	}
	
	public void setLiftSpeed(double speed) {
		leftLiftTalon.set(speed);
		rightLiftTalon.set(speed);
	}
	
	public double getEncoderCount() {
		return encoder.get(); 
	}

	public boolean isTopSwitchClosed() {
		return !topSwitch.get();
	}
	
	public boolean isBottomSwitchClosed() {
		return !bottomSwitch.get();
	}
	
	public boolean isCubeCollected() {
		return intakeSwitch.get();
	}
	
	public void arcadeDrive() {
		differentialDrive.arcadeDrive((RobotPreferences.collectorIntakeSpeed() * Robot.oi.manipulatorStick.getRawAxis(RobotMap.COLLECTOR_MOVE_AXIS)), 
				(RobotPreferences.collectorIntakeSpeed() * Robot.oi.manipulatorStick.getRawAxis(RobotMap.COLLECTOR_ROTATE_AXIS)));
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CollectorArcade());
    }
}

