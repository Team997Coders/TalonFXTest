package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase{
    private final TalonFX motorController;
    private final TalonFXConfigurator config;

    public Motor(int ID) {
        motorController = new TalonFX(ID);
       config = motorController.getConfigurator();
        
    }

    public void setMotorVoltage(double volts) { //-14 to 14
        motorController.setVoltage(volts);
    }

    public void setMotorOutput(double output) { //-1 to 1
        motorController.set(output);
    }

    public double getEncoderRotations() {
       return motorController.getPosition().getValueAsDouble();
    }

    public void setEncoderRotations(double rotations) {
        motorController.setPosition(rotations);
    }

    public Command setOutput(double output) {
        return this.run(() -> setMotorOutput(output));
    }
    
}
