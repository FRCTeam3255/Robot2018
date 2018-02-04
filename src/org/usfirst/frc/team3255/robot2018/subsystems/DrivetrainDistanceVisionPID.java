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
        return Robot.navigation.getTargetDistance();
    }
}
