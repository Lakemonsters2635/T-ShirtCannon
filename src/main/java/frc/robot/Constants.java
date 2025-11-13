// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.Encoder;


/** Add your docs here. */
public final class Constants {

    // CHANNELS
    public static final int LEFT_JOYSTICK_CHANNEL = 0; // For xbox controller
    public static final int RIGHT_JOYSTICK_CHANNEL = 1; // For xbox controller
    public static final int CONTROLLER_CHANNEL = 2; // For xbox controller

    public static final int RELAY_CHANNEL = 0; // Channel for relay (controls the shooting)
    public static final int ROTARY_CHANNEL = 11;//4; // Channel for rotating motor

    public final static int ROTATION_ENCODER_1 = 2; //DIO1
    public final static int ROTATION_ENCODER_2 = 1; //DIO2
    public static final int ROTATOR_SWITCH_CHANNEL = 0;//3; //DI03

    // BUTTON BINDINGS
    public static final int SHOOTER_BUTTON = 1; // For Joysticks
    public static final int ROTATION_BUTTON = 3; // For Joysticks

    // xbox controller Constants
    public final int LEFT_X_AXIS = 0;
    public final int LEFT_Y_AXIS = 1;
    public final static int LEFT_TRIGGER = 1;
    public final static int RIGHT_TRIGGER = 3;
    public final int RIGHT_X_AXIS = 4;
    public final int RIGHT_Y_AXIS = 5;    
    
    // ROTATION CONSTANTS
    public static final double ROTARY_SPEED = 1; // Speed of the rotation 
    public static final double ROTARY_STOP = 0; //Stop rotation    

    Encoder rotationEncoder;
    AnalogEncoder liftEncoder;
    PIDController liftPID;
    PIDController rotationPID;

    // MOTOR CONSTANTS
    public static final int id_LEFTMOTOR1 = 6;
    public static final int id_LEFTMOTOR2 = 3;

    public static final int id_RIGHTMOTOR1 = 16;
    public static final int id_RIGHTMOTOR2 = 17;
}
