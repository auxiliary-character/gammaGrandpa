package org.usfirst.frc.team4009.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4009.robot.Robot;
import org.usfirst.frc.team4009.robot.RobotMap;

/**
 *
 */
public class Shoot extends Command {
    Timer currentSensorCooldown;
    double jostleDirection;

    public Shoot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        currentSensorCooldown = new Timer();
        requires(Robot.shooter);
        requires(Robot.jostlator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        currentSensorCooldown.reset();
        jostleDirection = 1;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.shooter.set(-(Robot.oi.joystick2.getThrottle()+1)/2);
        if(Robot.jostlator.readCurrent() > RobotMap.jostleCurrentLimit && currentSensorCooldown.hasPeriodPassed(RobotMap.jostleCurrentCooldown)) {
            jostleDirection = -jostleDirection;
        }
        Robot.jostlator.set(jostleDirection);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.shooter.set(0);
        Robot.jostlator.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
