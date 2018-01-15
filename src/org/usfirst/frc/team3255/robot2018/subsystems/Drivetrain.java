package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.RobotMap;
import org.usfirst.frc.team3255.robot2018.commands.DriveArcade;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX leftFrontTalon = null;
	private WPI_TalonSRX leftBackTalon = null;
	private WPI_TalonSRX rightFrontTalon = null;
	private WPI_TalonSRX rightBackTalon = null;
	
	private Encoder leftEncoder = null;
	private Encoder rightEncoder = null;
	
	private DifferentialDrive differentialDrive = null;
 
	public Drivetrain() {
		leftFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
		leftBackTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
		rightFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
		rightBackTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);
		
		leftEncoder = new Encoder(RobotMap.DRIVETRAIN_LEFT_ENCODER_A, RobotMap.DRIVETRAIN_LEFT_ENCODER_B);
		rightEncoder = new Encoder(RobotMap.DRIVETRAIN_RIGHT_ENCODER_A, RobotMap.DRIVETRAIN_RIGHT_ENCODER_B);
		
		leftFrontTalon.setSafetyEnabled(false);
		leftBackTalon.setSafetyEnabled(false);
		rightFrontTalon.setSafetyEnabled(false);
		rightBackTalon.setSafetyEnabled(false);
		
		leftFrontTalon.setNeutralMode(NeutralMode.Brake);
		leftBackTalon.setNeutralMode(NeutralMode.Brake);
		rightFrontTalon.setNeutralMode(NeutralMode.Brake);
		rightBackTalon.setNeutralMode(NeutralMode.Brake);
		
		leftBackTalon.follow(leftFrontTalon);
		rightBackTalon.follow(rightFrontTalon);
	
		differentialDrive = new DifferentialDrive(leftFrontTalon, rightFrontTalon);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		differentialDrive.arcadeDrive(-moveSpeed, rotateSpeed);
	}
	
	public double getLeftEncoderCount() {
		return 	leftEncoder.get();
	}
	
	public double getRightEncoderCount() {
		return 	rightEncoder.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveArcade());
    }
}

