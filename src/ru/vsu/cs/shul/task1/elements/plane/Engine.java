package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Engine {

    private final int w, h;

    private int offsetX, offsetY, ticksFromStart;

    private final Orientation or;

    public Engine(int w, int h, int offsetX, int offsetY, Orientation or, int ticksFromStart) {
        this.w = w;
        this.h = h;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.or = or;
        this.ticksFromStart = ticksFromStart;
    }


    public void draw(Graphics2D g) {

        int minOrient = this.or.getCode();

        g.setColor(Color.BLACK);


        double valueOfPi = 2*Math.PI * (ticksFromStart % 10) / 10;

        double valueBetween = 2*Math.PI / 3;

        for (int i = 0; i < 3; i++) {

            GeneralPath screw = new GeneralPath();

            screw.moveTo(
                    offsetX + (w / 2.0 + minOrient * w * 0.1078) + w * 0.02538 * Math.cos(valueOfPi),
                    offsetY + (h / 2.0 - h * 0.053) + h * 0.0354 * -Math.sin(valueOfPi));

            screw.curveTo(
                    offsetX + (w / 2.0 + minOrient * w * 0.1078) + w * 0.02538 * Math.cos(valueOfPi),
                    offsetY + (h / 2.0 - h * 0.053) + h * 0.0354 * -Math.sin(valueOfPi),
                    offsetX + (w / 2.0 + minOrient * w * 0.1078) + w * 0.0634 * Math.cos(valueOfPi - Math.PI / 15),
                    offsetY + (h / 2.0 - h * 0.053) + h * 0.088 * -Math.sin(valueOfPi - Math.PI / 15),
                    offsetX + (w / 2.0 + minOrient * w * 0.1078) + w * 0.0888 * Math.cos(valueOfPi + Math.PI / 30),
                    offsetY + (h / 2.0 - h * 0.053) + h * 0.12389 * -Math.sin(valueOfPi + Math.PI / 30));

            screw.curveTo(
                    offsetX + (w / 2.0 + minOrient * w * 0.1078) + w * 0.0888 * Math.cos(valueOfPi + Math.PI / 30),
                    offsetY + (h / 2.0 - h * 0.053) + h * 0.12389 * -Math.sin(valueOfPi + Math.PI / 30),
                    offsetX + (w / 2.0 + minOrient * w * 0.1078) + w * 0.0634 * Math.cos(valueOfPi + Math.PI / 10),
                    offsetY + (h / 2.0 - h * 0.053) + h * 0.088 * -Math.sin(valueOfPi + Math.PI / 10),
                    offsetX + (w / 2.0 + minOrient * w * 0.1078) + w * 0.02538 * Math.cos(valueOfPi),
                    offsetY + (h / 2.0 - h * 0.053) + h * 0.0354 * -Math.sin(valueOfPi + Math.PI / 30));

            g.fill(screw);

            valueOfPi+= valueBetween;


        }

        GeneralPath engine = new GeneralPath();


        engine.moveTo(offsetX + w / 2.0 + minOrient * w * 0.104, offsetY + h / 2.0 - h * 0.0212);
        engine.lineTo(offsetX + w / 2.0 + minOrient * w * 0.076, offsetY + h / 2.0 - h * 0.053);
        engine.curveTo(offsetX + w / 2.0 + minOrient * w * 0.076, offsetY + h / 2.0 - h * 0.053, offsetX + w / 2.0 + minOrient * w * 0.082,
                offsetY + h / 2.0 - h * 0.088, offsetX + w / 2.0 + minOrient * 0.1015 * w, offsetY + h / 2.0 - h * 0.097);
        engine.lineTo(offsetX + w / 2.0 + minOrient * w * 0.1142, offsetY + h / 2.0 - h * 0.097);
        engine.curveTo(offsetX + w / 2.0 + minOrient * w * 0.1142, offsetY + h / 2.0 - h * 0.097, offsetX + w / 2.0 + minOrient * w * 0.1332,
                offsetY + h / 2.0 - h * 0.088, offsetX + w / 2.0 + minOrient * w * 0.1396, offsetY + h / 2.0 - h * 0.053);
        engine.lineTo(offsetX + w / 2.0 + minOrient * w * 0.1117, offsetY + h / 2.0 - h * 0.0212);
        engine.lineTo(offsetX + w / 2.0 + minOrient * w * 0.104, offsetY + h / 2.0 - h * 0.0212);

        g.setColor(Color.GRAY);

        g.fill(engine);

        g.setColor(Color.BLACK);


    }
}
