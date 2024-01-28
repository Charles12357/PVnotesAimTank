// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.chassis;
import edu.wpi.first.wpilibj2.command.RunCommand;

import com.ctre.phoenix.led.CANdle;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.candle;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final XboxController joystick = new XboxController(0);
  private chassis mchassis = new chassis();
  private candle mcandle = new candle();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */

  



  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    candlePurple();
    candleGold();
    YN();
    nolight();
    mcandle.YNlight();
    
   
    mchassis.setDefaultCommand(
    new RunCommand(() ->mchassis.drive(joystick.getLeftY()*0.4, joystick.getRightX()*0.4), mchassis));

  }


   private void configureBindings() {
     new JoystickButton(joystick, 2).whileTrue(Commands.runOnce(mcandle::candlePurple, mcandle).alongWith((Commands.run(mchassis::noteAim, mchassis))));
   }     
   private void YN() {
     new JoystickButton(joystick, 1).whileTrue(Commands.run(mchassis::ylight, mchassis))
                                                 .onFalse(Commands.runOnce(mcandle::nolight, mcandle));
   }        
   private void candlePurple() {
     new JoystickButton(joystick, 3).onTrue(Commands.runOnce(mcandle::candlePurple, mcandle));
   }       
  private void candleGold() {
     new JoystickButton(joystick, 4).onTrue(Commands.runOnce(mcandle::candleGold, mcandle));
   }       
  private void nolight() {
     new JoystickButton(joystick, 6).onTrue(Commands.runOnce(mcandle::nolight, mcandle));      
  }
}

