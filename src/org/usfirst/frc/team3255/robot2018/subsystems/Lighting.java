package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.RobotMap;
import org.usfirst.frc.team3255.robot2018.commands.LightingFrequency;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lighting extends Subsystem {
	
	Spark statusLighting = null;
	
	public Lighting(){
		statusLighting = new Spark(RobotMap.LIGHTING_STATUSLIGHTING);
	}

	public void setLighting(double frequency) {
		statusLighting.set(frequency);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LightingFrequency());
    }
}

