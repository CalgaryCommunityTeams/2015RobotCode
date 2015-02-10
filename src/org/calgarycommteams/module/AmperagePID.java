package org.calgarycommteams.module;

import edu.first.identifiers.Input;
import edu.first.module.actuators.SpeedController;
import edu.first.module.controllers.PIDController;
import edu.first.util.PowerUtils;

/**
 *
 * @author Joel Gallant
 */
public class AmperagePID extends PIDController {

    public AmperagePID(final int pdpPort, SpeedController output, double P) {
        super(new Input() {
            @Override
            public double get() {
                return PowerUtils.getCurrent(pdpPort);
            }
        }, output, P, 0, 0);
    }
}
