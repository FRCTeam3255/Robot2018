package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;

/**
 *
 */
public class DrivetrainDistanceVisionPID extends DriveDistancePID {
	
    // Initialize your subsystem here
    public DrivetrainDistanceVisionPID() {
    	super();
    }
   
    protected double returnPIDInput() {
        return Robot.navigation.getCubeDistance();
    }
    
    public boolean onRawTarget() {
    	if (Math.abs(getPIDController().getSetpoint() - returnPIDInput()) < tolerance) {
    		targetCounter = targetCounter + 1;
    	}
    	else {
    		targetCounter = 0;
    	}
    	
    	return (targetCounter >= 100);
    }
}
