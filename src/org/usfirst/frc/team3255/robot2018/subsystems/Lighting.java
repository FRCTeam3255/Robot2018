package org.usfirst.frc.team3255.robot2018.subsystems;

import org.usfirst.frc.team3255.robot2018.Robot;
import org.usfirst.frc.team3255.robot2018.RobotMap;
import org.usfirst.frc.team3255.robot2018.commands.LightingFrequency;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lighting extends Subsystem {
	
	Spark statusLighting = null;
	
	// Color 1 is Green
	// Color 2 is Pink

	public static final double CUBE_COLLECTED = -0.03; // Color 1 end to end
	public static final double CUBE_IDENTIFIED = -0.01; // Color 1 Larson Scanner
	public static final double SWITCH_IDENTIFIED = -0.33; // Larson scanner gray
	public static final double CUBE_ALIGNED = 0.15; // Color 1 Strobe
	public static final double SWITCH_ALIGNED = -0.05; // Strobe White
	public static final double SWITCH_ON_TARGET = 0.93; // Solid White
	public static final double READY_RED = 0.61; // Solid Red
	public static final double READY_BLUE = 0.87; // Solid Blue
	public static final double FAULT = -0.11; //Strobe Red
	public static final double DISABLED = 0.63; //Red Orange

	
	public Lighting(){
		statusLighting = new Spark(RobotMap.LIGHTING_STATUSLIGHTING);
	}

	public void setLighting(double frequency) {
		statusLighting.set(frequency);
	}
	
	public void update() {
		if(Robot.collector.isCubeCollected()) {
			setLighting(CUBE_COLLECTED);
		}
		else {
			if(Robot.navigation.isRedAlliance()) {
				setLighting(READY_RED);
			}
			else {
				setLighting(READY_BLUE);
			}
		}
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LightingFrequency());
    }
}

