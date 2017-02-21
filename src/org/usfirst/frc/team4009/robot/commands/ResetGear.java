package org.usfirst.frc.team4009.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4009.robot.Robot;
/**
 *
 */
public class ResetGear extends Command {

    public ResetGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.gear);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(Robot.gear.readLimitSwitch()){
            Robot.gear.set(1);
        }
        else{
            Robot.gear.set(0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.gear.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}