// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(1);
  private final WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(2);
  private final WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(1);
  private final WPI_TalonSRX backRightMotor = new WPI_TalonSRX(2);
  private AHRS navX = new AHRS(Port.kMXP);
  
  public DriveSubsystem() {
    frontLeftMotor.setInverted(true);
    backLeftMotor.setInverted(true);
  }

  public void tankDrive(double left, double right){
    frontLeftMotor.set(left);
    frontRightMotor.set(right);
    backLeftMotor.set(left);
    backRightMotor.set(right);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
        
      }
public double getAngle(){
          return navX.getAngle();
        }
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
