// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.DifferentialDrive2;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;

  private Timer shootTimer;
  private Timer rotateTimer;

  
  @Override
  public void robotInit(){
    System.out.println("Robot.robotInit()");
    m_robotContainer = new RobotContainer();
    // m_controller = new XboxController(Constants.CONTROLLER_CHANNEL);
    // shooterButton = new JoystickButton(m_leftStick, 1);
    // shootTimer = new Timer();
    rotateTimer = new Timer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }
    
  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    // TANK DRIVE
    m_robotContainer.m_tankDrive.drive(m_robotContainer.m_leftStick.getY(), m_robotContainer.m_rightStick.getY());
    m_robotContainer.m_tankDrive.drive(m_robotContainer.m_controller.getLeftY(), m_robotContainer.m_controller.getRightY());

    // ROTATION BUTTON
    // String enconderCounts = ""+m_robotContainer.m_RotarySubsystem.getEncoderCounts();
    // SmartDashboard.putNumber("Encoder Counts",m_robotContainer.m_RotarySubsystem.getEncoderCounts());

    // System.out.println(m_robotContainer.m_RotarySubsystem.getEncoderCounts());
    // if(m_robotContainer.m_leftStick.getTriggerPressed()) {
    //   m_robotContainer.m_ArmRotationCommand.initialize();
    //   rotateTimer.start();
    // }

    // if(rotateTimer.get() > 1 && !m_robotContainer.m_RotarySubsystem.rotatorSwitch.get()) {
    //   m_robotContainer.m_ArmRotationCommand.end(true);
    //   System.out.println(m_robotContainer.m_RotarySubsystem.rotatorSwitch.get());
    //   m_robotContainer.m_RotarySubsystem.resetEncoderCounts(); 
    //   rotateTimer.reset();
    // }

    // if(m_robotContainer.m_leftStick.getTriggerPressed()) {
    //   m_robotContainer.m_ArmRotationCommand.end(true);
    // }
    
   // System.out.println("On true area");
   
    // m_tankDrive.drive(m_controller.getLeftY()/2, m_controller.getRightY()/2);
    // shooterButton.onTrue(shooterCommand);

    // ALL OF THESE IF STATEMENTS ARE FOR TESTING THE RELAY STATES

    // if(m_leftStick.getY() > 0.1){  
    //   m_shooterSubsystem.shootForward(); // red
    // }
    // else if (m_leftStick.getY() < -0.1) {
    //   m_shooterSubsystem.shootBack(); // green
    // }
    // if(m_rightStick.getY() > 0.1){
    //   m_shooterSubsystem.shootOn(); // orange
    // }
    // else if (m_rightStick.getY() < -0.1) {
    //   m_shooterSubsystem.shootOff(); // no light
    // }

    /*  THIS IS THE ACTUAL TEST CODE FOR LAUNCHING THINGS :D
    When you press the trigger, it sets RELAY to the open state and after 0.5 seconds 
    and then sets it closed. (FIY: WE DON'T KNOW WHICH RELAY VALUES ARE CORRECT AND ACTUALLY WORK 
    SO WE NEED TO TEST EACH VALUE WITH THE GAS TANKFULL)
    */

    // SHOOT BUTTON
    // if (m_rightStick.getTriggerPressed()) {
    //   shootTimer.start();
    //   shooterCommand.initialize();
    //   System.out.println("Right Stick");
    // }
    // if (shootTimer.get() >= 0.03) {
    //   shooterCommand.end(true);
    //   System.out.println("Left Stick");
    //   shootTimer.stop();
    //   shootTimer.reset();
    //   // System.out.println(timer.get());
    // }
    
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
