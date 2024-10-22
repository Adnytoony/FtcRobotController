package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.Map;

public class DrivingUtils {

    private double tgtPower;
    private Gamepad gamepad1;
    private Gamepad gamepad2;

    private Telemetry telemetry;

    private Map<String, DcMotor> wheels;

    public DrivingUtils(Telemetry telemetry, Gamepad gamepad1, Gamepad gamepad2, Map<String, DcMotor> wheels) {
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
        tgtPower = 0;
    }

    public void managePower() {
        // run until the end of the match (driver presses STOP)
        double tgtPower = 0;
        double forwardPower = 0;
        double directiony = 0;
        double directionx = 0;

        //we need to decide how we are going to manage direction and speed with the sticks
        //one stick speed, other one direction
        //or manage speed and direction with one stick
        //arrange with drivers
        forwardPower = -this.gamepad1.left_stick_y;
        directiony =  -this.gamepad1.right_stick_y;
        directionx = -this.gamepad1.right_stick_x;
    wheels.get("motorFR").setPower(forwardPower);
        telemetry.addData("Target Power", tgtPower);
        telemetry.addData("Motor Power", wheels.get("motorFR").getPower());
        telemetry.addData("Status", "Running");
        telemetry.update();
    }
}

