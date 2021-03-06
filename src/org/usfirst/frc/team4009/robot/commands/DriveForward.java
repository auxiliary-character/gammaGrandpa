package org.usfirst.frc.team4009.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4009.robot.Robot;

/**
 *
 */
public class DriveForward extends Command {
	public DriveForward() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
        Robot.drive.drive(0,1,0);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
        Robot.drive.drive(0,0,0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
        end();
	}
}
