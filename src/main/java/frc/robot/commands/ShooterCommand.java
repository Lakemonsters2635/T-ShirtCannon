// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends Command {
  private ShooterSubsystem shooterSubsystem;
  Timer m_timer;

  double startTime;
  double endTime;
  double delay = 0.03; // How long we want the relay to be set to kForward
  boolean isShooterForward;

  /** Creates a new ShooterCommand. */
  public ShooterCommand(ShooterSubsystem shooterSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterSubsystem = shooterSubsystem;
    m_timer = new Timer();
    
    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.start();
    startTime = m_timer.get();

    shooterSubsystem.shootForward();
    isShooterForward =  shooterSubsystem.m_relay.get() == Value.kForward;
    System.out.println("In initialize: " + isShooterForward);
    System.out.println("Shootercommand is working");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    endTime = m_timer.get();
    SmartDashboard.putBoolean("isShooterForward", isShooterForward);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.shootOff();
    isShooterForward = shooterSubsystem.m_relay.get() == Value.kForward;
    System.out.println("In end method: " + isShooterForward);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (endTime-startTime > delay && isShooterForward == true) {
      System.out.println("DONNEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
      return true;
    }
    return false;
  }

}
