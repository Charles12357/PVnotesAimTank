package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.networktables.NetworkTableInstance;



public class chassis extends SubsystemBase{

    private final CANSparkMax Frontleft = new CANSparkMax(Constants.FL, MotorType.kBrushless);
    private final CANSparkMax Frontright = new CANSparkMax(Constants.FR, MotorType.kBrushless);
    private final CANSparkMax Rearleft = new CANSparkMax(Constants.RL, MotorType.kBrushless);
    private final CANSparkMax Rearright = new CANSparkMax(Constants.RR, MotorType.kBrushless);

    private final MotorController leftMotors = new MotorControllerGroup(Frontleft, Rearleft);
    private final MotorController rightMotors = new MotorControllerGroup(Frontright, Rearright);
    public DifferentialDrive tank = new DifferentialDrive(leftMotors, rightMotors);

    private photonvision m_Photonvision = new photonvision();
    CANdle candle1 = new CANdle(15);

    private double outputX;
    private double outputY;
    public boolean L;

    private boolean hasOrNot;
    private boolean hasOrNot2;
    private double targetSize;
    private double KP = 0.05;
    // private double targetSize2 = m_Photonvision.Area2();
    private double x;
    private double x2;
    public chassis(){
        Frontleft.restoreFactoryDefaults();
        Frontright.restoreFactoryDefaults();
        Rearleft.restoreFactoryDefaults();
        Rearright.restoreFactoryDefaults();

        Rearright.setInverted(true);
        Frontright.setInverted(true);

        Frontleft.setIdleMode(IdleMode.kBrake);
        Frontright.setIdleMode(IdleMode.kBrake);
        Rearleft.setIdleMode(IdleMode.kBrake);
        Rearright.setIdleMode(IdleMode.kBrake);
    }
    
        
    
    public void ylight() {
        hasOrNot = m_Photonvision.target();
        // hasOrNot2 = m_Photonvision.target2();
        if(hasOrNot2 || hasOrNot){
            System.out.println("YL");
            hasOrNot = m_Photonvision.target();
            // hasOrNot2 = m_Photonvision.target2();
            candle1.animate(new RainbowAnimation(0.6, 0.5, 60));
        }
        else if (!hasOrNot & !hasOrNot2){
        hasOrNot = m_Photonvision.target();
        // hasOrNot2 = m_Photonvision.target2();
        //set brightness
        candle1.configBrightnessScalar(1);
        //set color
        candle1.setLEDs(0, 0, 0);
        candle1.clearAnimation(0);
        }
    }
               

    public void noteAim(){
       hasOrNot = m_Photonvision.target();
//     //    hasOrNot2 = m_Photonvision.target2();
//     if(hasOrNot2 & !hasOrNot){
//         System.out.println(1);
//         int i = 1;
//         L=true;
//         x2 = m_Photonvision.PX2();
//     while(i!=0){            
//     if(x2 > 180){
//         x2 = m_Photonvision.PX2();
//         outputY = -0.2;
//     }
//     else if(x2 > 0.0 & x2 < 180.0){
//         x2 = m_Photonvision.PX2();
//         outputY = 0.2;
//     }
//     else if(x2<180 & x2>140){
//         x2 = m_Photonvision.PX2();
//         outputY = 0;
//         i = 0;
//     }
//         tank.arcadeDrive(0, outputY);
//     }
//     // outputX = -0.35;
//     // tank.arcadeDrive(-outputX, 0);
// }
//     else if(hasOrNot2 & hasOrNot){
//         System.out.println(2);
//     //     boolean w = true;
//     //     x2 = m_Photonvision.PX2();
//     // while(w){    
//     // if(x2 > 180){
//     //     x2 = m_Photonvision.PX2();
//     //     outputY = -0.2;
//     // }
//     // else if(x2 > 0.0 & x2 < 140.0){
//     //     x2 = m_Photonvision.PX2();
//     //     outputY = 0.2;
//     // }
//     // else if(x2<180 & x2>140){
//     //     x2 = m_Photonvision.PX2();
//     //     outputY = 0;
//     //     System.out.println(0);
//     //     w = false;
//     // }
             
//     //     tank.arcadeDrive(0, outputY);
//     // }
            
//         outputX = -0.35;
//         tank.arcadeDrive(-outputX, 0);
// }
        
    if(hasOrNot){
        int t = 1;
        System.out.println(3);
        x = m_Photonvision.PX();
    while(t!=0){
        System.out.println(outputY);
        x = m_Photonvision.PX();
    // if(x > 230 ){
    //     x = m_Photonvision.PX();
    //     outputY = (230-x)*0.0015;
    //     x = m_Photonvision.PX();
    // }
    if(x > 180){
        x = m_Photonvision.PX();
        outputY = -0.2;
        x = m_Photonvision.PX();
    }
    // else if(x > 0.0 & x < 140){
    //     x = m_Photonvision.PX();
    //     outputY = (140-x)*KP;
    //     x = m_Photonvision.PX();
    // }
      else if(x > 0.0 & x < 140){
        x = m_Photonvision.PX();
        outputY = 0.2;
        x = m_Photonvision.PX();
    }
    else if(x<180 & x>140){
        x = m_Photonvision.PX();
        outputY = 0;
        t = 0;
        x = m_Photonvision.PX();
    }
    else if(!hasOrNot2 & !hasOrNot){
        t = 0;
    }
        tank.arcadeDrive(0, outputY);
        targetSize = m_Photonvision.Area();
        outputX = 0;
    if(targetSize > 0.0 & targetSize < 4){
        targetSize = m_Photonvision.Area();
        outputX = -0.4;
    }
    if(targetSize > 4 & targetSize < 7){
        targetSize = m_Photonvision.Area();
        outputX = -0.2;
    }
    else if (targetSize > 7) {
        targetSize = m_Photonvision.Area();
        outputX = 0;
        candle1.configBrightnessScalar(1);
        candle1.setLEDs(0, 0, 0);
    }
    }
        tank.arcadeDrive(-outputX, 0);
}
    else if(!hasOrNot2 & !hasOrNot){
        L=false;
        outputX = 0;
        outputY = 0;
        tank.arcadeDrive(-outputX, outputY);
         //set brightness
        candle1.configBrightnessScalar(1);
        //set color
        candle1.setLEDs(0, 0, 0);
       }
    }
  
            // targetSize = Area.getDouble(0.0);
        // outputX = 0;
        // if(targetSize > 0.0 & targetSize < 30){
        //     outputX = -0.35;
        // }
        // else if (targetSize > 30) {
        //     outputX = 0;
        // }
        // tank.arcadeDrive(-outputX, 0);
    // }
    public boolean YN(){
    return L;
    }

    public void drive (double X, double Y){
        tank.arcadeDrive(-X, -Y);
    }
}




