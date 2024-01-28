package frc.robot.subsystems;

import frc.robot.Constants;
import org.photonvision.PhotonCamera;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.photonvision.targeting.PhotonPipelineResult;






public class photonvision extends SubsystemBase{
    static PhotonCamera camera = new PhotonCamera(Constants.cameraName);
    static PhotonPipelineResult result = camera.getLatestResult();
    public static boolean hasTargets = result.hasTargets();
    
    NetworkTable table = NetworkTableInstance.getDefault().getTable("photonvision/limelight");
    NetworkTableEntry notePoseX = table.getEntry("targetPixelsX");
    NetworkTableEntry hasTarget =table.getEntry("hasTarget");
    NetworkTableEntry Area = table.getEntry("targetArea");
    // NetworkTable table2 = NetworkTableInstance.getDefault().getTable("photonvision/C310");
    // NetworkTableEntry notePoseX2 = table2.getEntry("targetPixelsX");
    // NetworkTableEntry hasTarget2 =table2.getEntry("hasTarget");
    // NetworkTableEntry Area2 = table2.getEntry("targetArea");

    Boolean EhasOrNot = hasTarget.getBoolean(false);
    // Boolean EhasOrNot2 = hasTarget2.getBoolean(false);

    double EtargetSize = Area.getDouble(0.0);
    // double EtargetSize2 = Area2.getDouble(0.0);

    double Ex = notePoseX.getDouble(0.0);
    // double Ex2 = notePoseX2.getDouble(0.0);
   

    // NetworkTable table = NetworkTableInstance.getDefault().getTable("photonvision/C310");
    // NetworkTableEntry notePoseX = table.getEntry("targetPixelsX");

    public photonvision(){
     
    }

    // public void noteAim(){
    //     double x = notePoseX.getDouble(0.0);
    // }

    public boolean target() {
        hasTarget =table.getEntry("hasTarget");
        EhasOrNot = hasTarget.getBoolean(false);
        return EhasOrNot;
    }
    // public boolean target2() {
    //     hasTarget2 =table2.getEntry("hasTarget");
    //     EhasOrNot2 = hasTarget2.getBoolean(false);
    //     return EhasOrNot2;
    // }
    public double Area(){
        Area = table.getEntry("targetArea");
        EtargetSize = Area.getDouble(0.0);
        return EtargetSize;
    }
    // public double Area2(){
    //     Area2 = table2.getEntry("targetArea");
    //     EtargetSize2 = Area2.getDouble(0.0);
    //     return EtargetSize2;
    // }
    public double PX(){
        notePoseX = table.getEntry("targetPixelsX");
        Ex = notePoseX.getDouble(0.0);
        return Ex;
    }
    // public double PX2(){
    //     notePoseX2 = table2.getEntry("targetPixelsX");
    //     Ex2 = notePoseX2.getDouble(0.0);
    //     return Ex2;
    // }
    @Override
    public void periodic(){
        
    }

}


