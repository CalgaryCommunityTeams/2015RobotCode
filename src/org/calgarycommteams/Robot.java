package org.calgarycommteams;

import edu.first.module.Module;
import edu.first.module.subsystems.Subsystem;
import edu.first.robot.IterativeRobotAdapter;

/**
 *
 * @author Joel Gallant
 */
public class Robot extends IterativeRobotAdapter {

    private final Subsystem TELEOP_MODULES = new Subsystem(new Module[]{
        joysticks, drivetrain
    });
    private final Subsystem AUTO_MODULES = new Subsystem(new Module[]{});
    private final Subsystem ALL_MODULES = new Subsystem(new Module[]{
        TELEOP_MODULES, AUTO_MODULES, // Modules that are turned on conditionally
    });

    public Robot() {
        super("No name");
    }
}
