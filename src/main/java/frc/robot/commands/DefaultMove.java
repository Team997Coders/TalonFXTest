// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Motor;

import java.util.function.DoubleSupplier;

/**
 * A command to drive the robot with joystick input (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes - actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.RunCommand}.
 */
public class DefaultMove extends Command {
  private final Motor motor;
  private final DoubleSupplier m_forward;

  /**
   * Creates a new DefaultDrive.
   *
   * @param subsystem The motor subsystem this command wil run on.
   * @param forward The control input for driving forwards/backwards
   */
  public DefaultMove(Motor subsystem, DoubleSupplier forward) {
    motor = subsystem;
    m_forward = forward;
    addRequirements(motor);
  }

  @Override
  public void execute() {
    motor.setOutput(m_forward.getAsDouble());
  }
}