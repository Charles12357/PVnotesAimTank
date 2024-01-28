// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;
  // private chassis mchassis = new chassis();
  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    // mchassis.noteAim();
    // SmartDashboard.putNumber("x", NetworkTableInstance.getDefault().getTable("photonvision/limelight").getEntry("targetPixelsX").getDouble(0.0));
  }

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("x", NetworkTableInstance.getDefault().getTable("photonvision/limelight").getEntry("targetPixelsX").getDouble(0.0));
    SmartDashboard.putBoolean("hasTarget", NetworkTableInstance.getDefault().getTable("photonvision/limelight").getEntry("hasTarget").getBoolean(false));
    SmartDashboard.putNumber("Area", NetworkTableInstance.getDefault().getTable("photonvision/limelight").getEntry("targetArea").getDouble(0.0));
    SmartDashboard.putNumber("outputX", NetworkTableInstance.getDefault().getTable("photonvision/limelight").getEntry("targetPixelsX").getDouble(0.0));
  }

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
