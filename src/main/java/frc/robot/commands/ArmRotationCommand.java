// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RotarySubsystem;


public class ArmRotationCommand extends Command {
  /** Creates a new ArmRotationCommand. */
  private RotarySubsystem rotarySubsystem;
  private Timer timer;
  private double startTime;
  private double endTime;
  private double delay = .8;

  public ArmRotationCommand(RotarySubsystem rotarySubsystem){
    // Use addRequirements() here to declare subsystem dependencies.
    this.rotarySubsystem = rotarySubsystem;
    timer = new Timer();

    System.out.println("ArmRotationCommand Constructor");

    addRequirements(this.rotarySubsystem);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // rotarySubsystem.resetEncoderCounts();
    System.out.println("ArmRotationCommand.initialize()");

    rotarySubsystem.rotate();
    timer.reset();
    timer.start();
    startTime = timer.get();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    endTime = timer.get();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    rotarySubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // System.out.println(m_RotarySubsystem.getEncoderCounts());
    if (timer.get() >= delay && !rotarySubsystem.getRotatorSwitch()) {
      System.out.println("Passed delay");
      if(!rotarySubsystem.getRotatorSwitch()){
        return true;
      }
      rotarySubsystem.stop();
      return true;  
    }
    return false;
  }
}
