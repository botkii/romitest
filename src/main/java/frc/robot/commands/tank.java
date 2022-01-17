// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class tank extends CommandBase {
  private RomiDrivetrain drivetrain;
  private DoubleSupplier lSpeed;
  private DoubleSupplier rSpeed;

  /** Creates a new tank. */
  public tank(RomiDrivetrain drivetrain, DoubleSupplier lSpeed, DoubleSupplier rSpeed) {
    this.drivetrain = drivetrain;
    this.lSpeed = lSpeed;
    this.rSpeed = rSpeed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.tankDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.tankDrive(lSpeed.getAsDouble(), rSpeed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
