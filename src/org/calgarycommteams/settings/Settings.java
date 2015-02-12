package org.calgarycommteams.settings;

import edu.first.util.Properties;
import edu.first.util.preferences.DoublePreference;
import java.io.File;

/**
 *
 * @author Joel Gallant
 */
public interface Settings {

    Properties settingsFile = new Properties(new File("/home/settings.txt"));

    double JOYSTICK_DEADBAND = settingsFile.toDouble("JOYSTICK_DEADBAND", 0.05);
    String DRIVING_FORMAT = settingsFile.getValue("DRIVING_FORMAT", "arcade");
    boolean SINGLE_DRIVER = settingsFile.toBoolean("SINGLE_DRIVER", false);
    double LOADER_MAX_PID_SPEED = settingsFile.toDouble("LOADER_MAX_PID_SPEED", 0.5);
    DoublePreference LOADER_P = new DoublePreference("LOADER_P", 0.5),
            LOADER_I = new DoublePreference("LOADER_I", 0),
            LOADER_D = new DoublePreference("LOADER_D", 0);
}
