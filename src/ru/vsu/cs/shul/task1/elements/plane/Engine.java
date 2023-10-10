package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Engine {

    private final int w, h;

    private int offsetX, offsetY;

    private final Orientation or;

    public Engine(int w, int h, int offsetX, int offsetY, Orientation or) {
        this.w = w;
        this.h = h;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.or = or;
    }


    public void draw(Graphics2D g) {

        int minOrient = this.or.getCode();

        int minus = 1;

        g.setColor(Color.BLACK);

        for (int i = 0; i < 2; i++) {
            minus *= -1;

            GeneralPath screw = new GeneralPath();

            screw.moveTo(offsetX +( w / 2 + minOrient * w * 0.1078) + w * 0.02538 * minus * Math.cos(Math.PI/6), offsetY + (h / 2 - h * 0.053) + h * 0.0354 * -Math.sin(Math.PI/6));

            screw.curveTo(offsetX +(w / 2 + minOrient * w * 0.1078) + w * 0.02538 * minus * Math.cos(Math.PI/6), offsetY + (h / 2 - h * 0.053) + h * 0.0354 * -Math.sin(Math.PI/6),
                    offsetX +(w / 2 + minOrient * w * 0.1078) + w * 0.0634 * minus * Math.cos(Math.PI/10), offsetY + (h / 2 - h * 0.053) + h * 0.088 * -Math.sin(Math.PI/10),
                    offsetX +(w / 2 + minOrient * w * 0.1078) + w * 0.0888 * minus * Math.cos(Math.PI/5), offsetY + (h / 2 - h * 0.053) + h * 0.12389 * -Math.sin(Math.PI/5));

            screw.curveTo(offsetX +(w / 2 + minOrient * w * 0.1078) + w * 0.0888 * minus * Math.cos(Math.PI/5), offsetY + (h / 2 - h * 0.053) + h * 0.12389 * -Math.sin(Math.PI/5),
                    offsetX +(w / 2 + minOrient * w * 0.1078) + w * 0.0634 * minus * Math.cos(Math.PI*0.3), offsetY + (h / 2 - h * 0.053) + h * 0.088 * -Math.sin(Math.PI*0.3),
                    offsetX +(w / 2 + minOrient * w * 0.1078) + w * 0.02538 * minus * Math.cos(Math.PI/5), offsetY + (h / 2 - h * 0.053) + h * 0.0354 * -Math.sin(Math.PI/5));

            g.fill(screw);


        }

        GeneralPath engine = new GeneralPath();


        engine.moveTo(offsetX + w / 2 + minOrient * w * 0.104, offsetY + h / 2 - h * 0.0212);
        engine.lineTo(offsetX + w / 2 + minOrient * w * 0.076, offsetY + h / 2 - h * 0.053);
        engine.curveTo(offsetX + w / 2 + minOrient * w * 0.076, offsetY + h / 2 - h * 0.053, offsetX + w / 2 + minOrient * w * 0.082,
                offsetY + h / 2 - h * 0.088, offsetX + w / 2 + minOrient * 0.1015 * w, offsetY + h / 2 - h * 0.097);
        engine.lineTo( offsetX + w / 2 + minOrient * w * 0.1142, offsetY + h / 2 - h * 0.097);
        engine.curveTo(offsetX + w / 2 + minOrient * w * 0.1142, offsetY + h / 2 - h * 0.097, offsetX + w / 2 + minOrient * w * 0.1332,
                offsetY + h / 2 - h * 0.088, offsetX + w / 2 + minOrient * w * 0.1396, offsetY + h / 2 - h * 0.053);
        engine.lineTo( offsetX + w / 2 + minOrient * w * 0.1117, offsetY + h / 2 - h * 0.0212);
        engine.lineTo(offsetX + w / 2 + minOrient * w * 0.104, offsetY + h / 2 - h * 0.0212);

        g.setColor(Color.GRAY);

        g.fill(engine);

        g.setColor(Color.BLACK);



    }
}
