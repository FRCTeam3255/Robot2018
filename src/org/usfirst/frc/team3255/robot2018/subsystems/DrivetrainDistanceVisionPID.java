package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotPreferences;

/**
 *
 */
public class DrivetrainDistanceVisionPID extends DriveDistancePID {
	
    // Initialize your subsystem here
    public DrivetrainDistanceVisionPID() {
    	super();
    }
   
    protected double returnPIDInput() {
        return Robot.navigation.getTargetDistance();
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
