package org.calgarycommteams;

import edu.first.identifiers.Function;
import edu.first.identifiers.TransformedOutput;
import edu.first.module.Module;
import edu.first.module.joysticks.BindingJoystick;
import edu.first.module.joysticks.BindingJoystick.DualAxisBind;
import edu.first.module.subsystems.Subsystem;
import edu.first.robot.IterativeRobotAdapter;

/**
 *
 * @author Joel Gallant
 */
public class Robot extends IterativeRobotAdapter {

	private final Subsystem TELEOP_MODULES = new Subsystem(new Module[] {
			joysticks, drive, arm });
	private final Subsystem AUTO_MODULES = new Subsystem(new Module[] {});
	private final Subsystem ALL_MODULES = new Subsystem(new Module[] {
			TELEOP_MODULES, AUTO_MODULES });

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
	}

	private void addBinds() {
		if (DRIVING_FORMAT.equals("tank")) {
			driver.addAxisBind(drivetrain.getTank(
					driver.getLeftDistanceFromMiddle(),
					driver.getRightDistanceFromMiddle()));
		} else { // default is arcade
			driver.addAxisBind(new DualAxisBind(driver
					.getLeftDistanceFromMiddle(), driver.getRightX()) {
				@Override
				public void doBind(double axis1, double axis2) {
					drivetrain.arcadeDrive(axis1, -axis2, true);
				}
			});
		}

		BindingJoystick.AxisBind manualArmControl = new BindingJoystick.AxisBind(
				operator.getTriggers(), new TransformedOutput(armMotor, new Function.OppositeFunction()));

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
