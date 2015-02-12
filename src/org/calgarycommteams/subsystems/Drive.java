package org.calgarycommteams.subsystems;

import edu.first.module.Module;
import edu.first.module.actuators.Drivetrain;
import edu.first.module.actuators.TalonModule;
import edu.first.module.actuators.TalonModuleGroup;
import edu.first.module.subsystems.Subsystem;
import org.calgarycommteams.settings.Ports;

/**
 *
 * @author Joel Gallant
 */
public interface Drive extends Ports {

    TalonModuleGroup leftDrive = new TalonModuleGroup(new TalonModule[]{
        new TalonModule(LEFT_DRIVE_1),
        new TalonModule(LEFT_DRIVE_2)
    });
    TalonModuleGroup rightDrive = new TalonModuleGroup(new TalonModule[]{
        new TalonModule(RIGHT_DRIVE_1),
        new TalonModule(RIGHT_DRIVE_2)
    });
    Drivetrain drivetrain = new Drivetrain(leftDrive, rightDrive);
    
    Subsystem drive = new Subsystem(new Module[] {
        drivetrain,
        leftDrive, rightDrive
    });
}
