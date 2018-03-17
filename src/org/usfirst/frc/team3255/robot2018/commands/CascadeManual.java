package org.usfirst.frc.team3255.robot2018.commands;

import org.usfirst.frc.team3255.robot2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CascadeManual extends CommandGroup {

	protected boolean isBackAndBottom = false;
	
    public CascadeManual() {
    	addSequential(new CascadeManualMove());
    	if (isBackAndBottom) {
    		addSequential(new CollectorArmFront());
    		addSequential(new CascadeManualMove());
    	}
    }
    protected void inialized() {
    	isBackAndBottom = (Robot.collector.isBackArmSwitch() && Robot.cascadeLift.isBottomSwitchClosed());
    }
    protected void end() {
    	Robot.cascadeLift.setLiftSpeed(0.0);
    	Robot.cascadeLift.lockLift();
    }
    protected void interrupted() {
    	end();
    }
}
