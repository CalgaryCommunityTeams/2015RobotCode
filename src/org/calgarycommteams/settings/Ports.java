package org.calgarycommteams.settings;

import edu.first.util.Properties;
import java.io.File;

/**
 *
 * @author Joel Gallant
 */
public interface Ports {

    Properties portsFile = new Properties(new File("/home/ports.txt"));

    // BACKUPS
    // --- Drivetrain
    int _leftDrive1 = 1,
            _leftDrive2 = 2;
    int _rightDrive1 = 3,
            _rightDrive2 = 4;
    // --- Arm
    int _armMotor = 5;
    int _armPosition = 1;
    // VALUES
    // --- Drivetrain
    int LEFT_DRIVE_1 = portsFile.toInt("LeftDrive1", _leftDrive1),
            LEFT_DRIVE_2 = portsFile.toInt("LeftDrive2", _leftDrive2);
    int RIGHT_DRIVE_1 = portsFile.toInt("RightDrive1", _rightDrive1),
            RIGHT_DRIVE_2 = portsFile.toInt("RightDrive2", _rightDrive2);
    // --- Arm
    int ARM_MOTOR = portsFile.toInt("ArmMotor", _armMotor),
            ARM_POSITION = portsFile.toInt("ArmPosition", _armPosition);
}
