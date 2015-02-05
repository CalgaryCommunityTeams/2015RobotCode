package org.calgarycommteams.settings;

import edu.first.util.Properties;
import java.io.File;

/**
 *
 * @author Joel Gallant
 */
public interface Settings {

    Properties settingsFile = new Properties(new File("/home/settings.txt"));

    double JOYSTICK_DEADBAND = settingsFile.toDouble("JOYSTICK_DEADBAND", 0.05);
}
