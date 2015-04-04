package org.calgarycommteams.settings;

import java.io.File;

import edu.first.util.Properties;

/**
 *
 * @author Joel Gallant
 */
public interface Settings {

    Properties settingsFile = new Properties(new File("/home/lvuser/settings.txt"));

    double JOYSTICK_DEADBAND = settingsFile.toDouble("JOYSTICK_DEADBAND", 0.1);
    String DRIVING_FORMAT = settingsFile.getValue("DRIVING_FORMAT", "arcade");
    boolean SINGLE_DRIVER = settingsFile.toBoolean("SINGLE_DRIVER", false);
}
