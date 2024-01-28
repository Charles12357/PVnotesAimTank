package frc.robot.subsystems;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.RainbowAnimation;
import edu.wpi.first.wpilibj.PowerDistribution;
import com.ctre.phoenix6.mechanisms.swerve.utility.PhoenixPIDController;
import frc.robot.subsystems.chassis;



public class candle extends SubsystemBase {
   

    private photonvision m_Photonvision = new photonvision();

        //CANdle stuff
        //purple = 80, 45, 127
        //gold = 255, 200, 46
        //define candle
        CANdle candle1 = new CANdle(15);
        //create a rainbow anim.
        RainbowAnimation rainbowAnimation = new RainbowAnimation(1, 1, 0);
        boolean K = m_Photonvision.target();





private PowerDistribution pDH;



   
    public candle() {
pDH = new PowerDistribution();
 addChild("PDH",pDH);
 


    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    //CANdle
    //purple = 80, 45, 127
    //gold = 255, 200, 46

    public void candlePurple(){
             //set brightness
             candle1.configBrightnessScalar(1);
             //set color
             candle1.setLEDs(80, 45, 127);
             

    }
    

    public void candleGold(){
        //set brightness
        candle1.configBrightnessScalar(1);
        //set color
        candle1.setLEDs(255, 200, 46);
    }
    public void nolight(){
        //set brightness
        candle1.configBrightnessScalar(1);
        //set color
        candle1.setLEDs(0, 0, 0);
        candle1.clearAnimation(0);
}
    public void YNlight(){
        if(!K){
        //set brightness
        candle1.configBrightnessScalar(1);
        //set color
        candle1.setLEDs(0, 0, 0);  
        }
    }
    public void rainbow(){
        
    candle1.animate(new RainbowAnimation(0.6, 0.5, 60));
}
}

