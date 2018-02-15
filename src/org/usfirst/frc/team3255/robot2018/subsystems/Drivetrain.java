package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotMap;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;
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
	
	private Encoder encoder = null;
	
	private DifferentialDrive differentialDrive = null;
	
	private boolean liftClampingEnabled = true;
	private boolean pitchSafetyEnabled = true;
 
	public Drivetrain() {
		leftFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
		leftBackTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
		rightFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
		rightBackTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);
		
		leftFrontTalon.setNeutralMode(NeutralMode.Brake);
		leftBackTalon.setNeutralMode(NeutralMode.Brake);
		rightFrontTalon.setNeutralMode(NeutralMode.Brake);
		rightBackTalon.setNeutralMode(NeutralMode.Brake);
		
		leftFrontTalon.setSafetyEnabled(false);
		leftBackTalon.setSafetyEnabled(false);
		rightFrontTalon.setSafetyEnabled(false);
		rightBackTalon.setSafetyEnabled(false);
		
		encoder = new Encoder(RobotMap.DRIVETRAIN_ENCODER_A, RobotMap.DRIVETRAIN_ENCODER_B);
		
		leftBackTalon.follow(leftFrontTalon);
		rightBackTalon.follow(rightFrontTalon);
	
		differentialDrive = new DifferentialDrive(leftFrontTalon, rightFrontTalon);
		differentialDrive.setSafetyEnabled(false);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		arcadeDrive(moveSpeed, rotateSpeed, true);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed, boolean squaredInputs) {
		if(isLiftClampingEnabled() == true) {
			double clampSpeed = (1.0 - (Robot.collector.getCollectorHeight() / RobotPreferences.drivetrainClampMaxHeight()));
			
			if(clampSpeed < 0) {
				clampSpeed = 0;
			}
			else if(clampSpeed > 1) {
				clampSpeed = 1;
			}
		
			if(moveSpeed > 0) {
				if(moveSpeed > clampSpeed) {
					moveSpeed = clampSpeed;
				}
			}
			else if(moveSpeed < 0) {
				if(moveSpeed < -clampSpeed) {
					moveSpeed = -clampSpeed;
				}
			}
			
			if(rotateSpeed > 0) {
				if(rotateSpeed > clampSpeed) {
					rotateSpeed = clampSpeed;
				}
			}
			else if(rotateSpeed < 0) {
				if(rotateSpeed < -clampSpeed) {
					rotateSpeed = -clampSpeed;
				}
			}
		}
		
		if(Robot.oi.driverStick.getRawButton(6)) {
			moveSpeed = moveSpeed * RobotPreferences.drivetrainSlowSpeed();
			rotateSpeed = rotateSpeed * RobotPreferences.drivetrainSlowSpeed();
		}

		if(isPitchSafetyEnabled() == true) {
			double currentPitch = Robot.navigation.getPitch();
			double maxPitch = RobotPreferences.drivetrainMaxPitch();
			
			if(currentPitch > maxPitch) {
				moveSpeed = 0;
			}
		}

		differentialDrive.arcadeDrive(moveSpeed, rotateSpeed, squaredInputs);
	}
	
	public double getEncoderCount() {
		return  encoder.get();
	}
	
	// returns drivetrain encoder distance in inches
	public double getEncoderDistance() {
		return (encoder.get() / (double) RobotPreferences.drivetrainPulsePerFoot()) * 12;	
	}
	
	public void resetEncoder() {
		encoder.reset();
	}
	
	public double getSpeed() {
		return leftFrontTalon.get();
	}
	
	public void setLiftClamping(boolean enabled) {
		liftClampingEnabled = enabled;
	}
	
	public boolean isLiftClampingEnabled() {
		return liftClampingEnabled;
	}
		
	public void setPitchSafety(boolean enabled) {
		pitchSafetyEnabled = enabled;
	}
	
	public boolean isPitchSafetyEnabled() {
		return pitchSafetyEnabled;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveArcade());
    }
}

