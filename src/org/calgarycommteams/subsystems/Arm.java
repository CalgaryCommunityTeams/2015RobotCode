package org.calgarycommteams.subsystems;

import edu.first.identifiers.Function;
import edu.first.identifiers.TransformedOutput;
import edu.first.module.Module;
import edu.first.module.actuators.TalonModule;
import edu.first.module.controllers.PIDController;
import edu.first.module.sensors.AnalogInput;
import edu.first.module.subsystems.Subsystem;
import org.calgarycommteams.settings.Ports;
import org.calgarycommteams.settings.Settings;

/**
 *
 * @author Joel Gallant
 */
public interface Arm extends Ports, Settings {

    TalonModule armMotor = new TalonModule(ARM_MOTOR);
    AnalogInput armPosition = new AnalogInput(ARM_POSITION);

    Subsystem arm = new Subsystem(new Module[]{
        armMotor, armPosition
    });

    PIDController armController = new PIDController(armPosition,
            new TransformedOutput(armMotor, new Function.ProductFunction(LOADER_MAX_PID_SPEED))
    );
}
