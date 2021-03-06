package org.calgarycommteams.settings;

import edu.first.util.Properties;
import java.io.File;

/**
 *
 * @author Joel Gallant
 */
public interface Ports {

    Properties portsFile = new Properties(new File("/home/lvuser/ports.txt"));

    // BACKUPS
    // --- Drivetrain
    int _leftDrive1 = 0,
            _leftDrive2 = 1;
    int _rightDrive1 = 2,
            _rightDrive2 = 3;
    // --- Arm
    int _armMotor = 4;
    // VALUES
    // --- Drivetrain
    int LEFT_DRIVE_1 = portsFile.toInt("LeftDrive1", _leftDrive1),
            LEFT_DRIVE_2 = portsFile.toInt("LeftDrive2", _leftDrive2);
    int RIGHT_DRIVE_1 = portsFile.toInt("RightDrive1", _rightDrive1),
            RIGHT_DRIVE_2 = portsFile.toInt("RightDrive2", _rightDrive2);
    // --- Arm
    int ARM_MOTOR = portsFile.toInt("ArmMotor", _armMotor);
}
