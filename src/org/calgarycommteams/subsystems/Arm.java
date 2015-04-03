package org.calgarycommteams.subsystems;

import org.calgarycommteams.settings.Ports;
import org.calgarycommteams.settings.Settings;

import edu.first.module.Module;
import edu.first.module.actuators.TalonModule;
import edu.first.module.subsystems.Subsystem;

/**
 *
 * @author Joel Gallant
 */
public interface Arm extends Ports, Settings {

    TalonModule armMotor = new TalonModule(ARM_MOTOR);

    Subsystem arm = new Subsystem(new Module[]{
        armMotor
    });
}
