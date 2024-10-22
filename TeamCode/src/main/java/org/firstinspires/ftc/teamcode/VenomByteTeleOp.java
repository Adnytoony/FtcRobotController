package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.HashMap;
import java.util.Map;

@TeleOp

public class VenomByteTeleOp extends LinearOpMode {
    private Gyroscope imu;
    private DigitalChannel digitalTouch;
    private DistanceSensor sensorColorRange;
    private Servo servoTest;


    @Override
    public void runOpMode() {
        imu = hardwareMap.get(Gyroscope.class, "imu");
        Map wheels = new HashMap();
        wheels.put("motorFR",hardwareMap.get(DcMotor.class, "motorFR"));
        wheels.put("motorFL",hardwareMap.get(DcMotor.class, "motorFL"));
        wheels.put("motorRR",hardwareMap.get(DcMotor.class, "motorRR"));
        wheels.put("motorRL",hardwareMap.get(DcMotor.class, "motorRL"));
        digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        servoTest = hardwareMap.get(Servo.class, "servoTest");
        DrivingUtils driving = new DrivingUtils(telemetry,this.gamepad1, this.gamepad2, wheels);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        driving.managePower();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();


        }
    }
}
