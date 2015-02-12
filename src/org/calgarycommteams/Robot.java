package org.calgarycommteams;

import edu.first.module.Module;
import edu.first.module.joysticks.BindingJoystick;
import edu.first.module.subsystems.Subsystem;
import edu.first.robot.IterativeRobotAdapter;

/**
 *
 * @author Joel Gallant
 */
public class Robot extends IterativeRobotAdapter {

    private final Subsystem TELEOP_MODULES = new Subsystem(new Module[]{
        joysticks, drivetrain, arm
    });
    private final Subsystem AUTO_MODULES = new Subsystem(new Module[]{});
    private final Subsystem ALL_MODULES = new Subsystem(new Module[]{
        TELEOP_MODULES, AUTO_MODULES,
        // Modules that are turned on conditionally
        armController
    });

    public Robot() {
        super("Community Team Robot");
    }

    @Override
    public void init() {
        ALL_MODULES.init();
        addBinds();
    }

    @Override
    public void endDisabled() {
        armController.setPID(LOADER_P.get(), LOADER_I.get(), LOADER_D.get());
    }

    private void addBinds() {
        if (DRIVING_FORMAT.equals("tank")) {
            driver.addAxisBind(drivetrain.getTank(
                    driver.getLeftDistanceFromMiddle(), driver.getLeftDistanceFromMiddle()));
        } else { // default is arcade
            driver.addAxisBind(drivetrain.getArcade(
                    driver.getLeftDistanceFromMiddle(), driver.getLeftX()));
        }

        BindingJoystick.AxisBind manualArmControl
                = new BindingJoystick.AxisBind(operator.getTriggers(), armMotor);

        operator.addBind(manualArmControl);
    }

    @Override
    public void initTeleoperated() {
        TELEOP_MODULES.enable();
    }

    @Override
    public void periodicTeleoperated() {
        driver.doBinds();
        operator.doBinds();
    }

    @Override
    public void endTeleoperated() {
        TELEOP_MODULES.disable();
    }
}
