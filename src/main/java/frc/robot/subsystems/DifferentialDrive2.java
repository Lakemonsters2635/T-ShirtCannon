// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PWM;

// DifferentialDrive2 expects 4 motors instead of 2 motors.
public class DifferentialDrive2 extends SubsystemBase {
  // Instantiates drive motors
  private final TalonSRX m_leftMotor1;
  private final TalonSRX m_leftMotor2;
  private final TalonSRX m_rightMotor1;
  private final TalonSRX m_rightMotor2;
  
  public DifferentialDrive2() {
    m_leftMotor1 = new TalonSRX(Constants.id_LEFTMOTOR1);
    m_leftMotor2 = new TalonSRX(Constants.id_LEFTMOTOR2);
    m_rightMotor1 = new TalonSRX(Constants.id_RIGHTMOTOR1);
    m_rightMotor2 = new TalonSRX(Constants.id_RIGHTMOTOR2);
  
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.

    // // TODO
    // // based upon gearbox configuration, some of the motors may need to be inverted
    // // such that the motors do not fight eachother and so that the robot goes forward 
    // // and does not spin.
    m_leftMotor1.setInverted(true);
    m_leftMotor2.setInverted(true);
    // m_rightMotor1.setInverted(true);
    // m_rightMotor2.setInverted(true);
  }

  public void drive(double lJoystick, double rJoystick)
  {
    m_leftMotor1.set(ControlMode.PercentOutput,lJoystick);
    m_leftMotor2.set(ControlMode.PercentOutput,lJoystick);

    m_rightMotor1.set(ControlMode.PercentOutput,rJoystick);
    m_rightMotor2.set(ControlMode.PercentOutput,rJoystick);
  }

    
  @Override  
  public void periodic() {

    drive(RobotContainer.m_controller.getLeftY()/2,RobotContainer.m_controller.getRawAxis(5)/2);
    // drive(RobotContainer.m_rightStick.getY(),RobotContainer.m_rightStick.getY());
    // This method will be called once per scheduler run
  }
}
