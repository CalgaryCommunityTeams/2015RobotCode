package org.calgarycommteams.subsystems;

import edu.first.module.Module;
import edu.first.module.joysticks.XboxController;
import edu.first.module.subsystems.Subsystem;
import org.calgarycommteams.settings.Settings;

/**
 *
 * @author Joel Gallant
 */
public interface Joysticks extends Settings {

    XboxController driver = new XboxController(1, JOYSTICK_DEADBAND);
    XboxController operator = new XboxController(2, JOYSTICK_DEADBAND);

    Subsystem joysticks = new Subsystem(new Module[]{
        driver, operator
    });
}
