package org.calgarycommteams.subsystems;

import edu.first.module.Module;
import edu.first.module.actuators.Drivetrain;
import edu.first.module.actuators.VictorModule;
import edu.first.module.actuators.VictorModuleGroup;
import edu.first.module.subsystems.Subsystem;
import org.calgarycommteams.settings.Ports;

/**
 *
 * @author Joel Gallant
 */
public interface Drive extends Ports {

    VictorModuleGroup leftDrive = new VictorModuleGroup(new VictorModule[]{
        new VictorModule(LEFT_DRIVE_1),
        new VictorModule(LEFT_DRIVE_2)
    });
    VictorModuleGroup rightDrive = new VictorModuleGroup(new VictorModule[]{
        new VictorModule(RIGHT_DRIVE_1),
        new VictorModule(RIGHT_DRIVE_2)
    });
    Drivetrain drivetrain = new Drivetrain(leftDrive, rightDrive);
    
    Subsystem drive = new Subsystem(new Module[] {
        drivetrain,
        leftDrive, rightDrive
    });
}
