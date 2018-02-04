package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;

/**
 *
 */
public class DriveDistanceEncoderPID extends DriveDistancePID {
	
    // Initialize your subsystem here
    public DriveDistanceEncoderPID() {
    	super();
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
       return Robot.drivetrain.getEncoderDistance();
    }
}
