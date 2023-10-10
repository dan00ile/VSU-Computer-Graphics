package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Engine {

    private final int w, h;

    private final Orientation or;

    public Engine(int w, int h, int x, int y, Orientation or) {
        this.w = w;
        this.h = h;
        this.or = or;
    }


    public void draw(Graphics2D g) {


        int minOrient = this.or.getCode();

        int minus = 1;

        g.setColor(Color.BLACK);

        for (int i = 0; i < 2; i++) {
            minus *= -1;

            GeneralPath screw = new GeneralPath();

            screw.moveTo((w / 2 + minOrient * w * 0.1078) + w * 0.02538 * minus * Math.cos(Math.PI/6), (h / 2 - h * 0.053) + h * 0.0354 * -Math.sin(Math.PI/6));

            screw.curveTo((w / 2 + minOrient * w * 0.1078) + w * 0.02538 * minus * Math.cos(Math.PI/6), (h / 2 - h * 0.053) + h * 0.0354 * -Math.sin(Math.PI/6),
                    (w / 2 + minOrient * w * 0.1078) + w * 0.0634 * minus * Math.cos(Math.PI/10), (h / 2 - h * 0.053) + h * 0.088 * -Math.sin(Math.PI/10),
                    (w / 2 + minOrient * w * 0.1078) + w * 0.0888 * minus * Math.cos(Math.PI/5), (h / 2 - h * 0.053) + h * 0.12389 * -Math.sin(Math.PI/5));

            screw.curveTo((w / 2 + minOrient * w * 0.1078) + 70 * minus * Math.cos(Math.PI/5), (h / 2 - h * 0.053) + h * 0.12389 * -Math.sin(Math.PI/5),
                    (w / 2 + minOrient * w * 0.1078) + w * 0.0634 * minus * Math.cos(Math.PI*0.3), (h / 2 - h * 0.053) + h * 0.088 * -Math.sin(Math.PI*0.3),
                    (w / 2 + minOrient * w * 0.1078) + w * 0.02538 * minus * Math.cos(Math.PI/5), (h / 2 - h * 0.053) + h * 0.0354 * -Math.sin(Math.PI/5));

            g.fill(screw);


        }

        GeneralPath engine = new GeneralPath();


        engine.moveTo(w / 2 + minOrient * w * 0.104, h / 2 - h * 0.0212);
        engine.lineTo(w / 2 + minOrient * w * 0.076, h / 2 - h * 0.053);
        engine.curveTo(w / 2 + minOrient * w * 0.076, h / 2 - h * 0.053, w / 2 + minOrient * w * 0.082, h / 2 - h * 0.088, w / 2 + minOrient * 0.1015 * w, h / 2 - h * 0.097);
        engine.lineTo( w / 2 + minOrient * w * 0.1142, h / 2 - h * 0.097);
        engine.curveTo(w / 2 + minOrient * w * 0.1142, h / 2 - h * 0.097, w / 2 + minOrient * w * 0.1332, h / 2 - h * 0.088, w / 2 + minOrient * w * 0.1396, h / 2 - h * 0.053);
        engine.lineTo( w / 2 + minOrient * w * 0.1117, h / 2 - h * 0.0212);
        engine.lineTo(w / 2 + minOrient * w * 0.104, h / 2 - h * 0.0212);

        g.setColor(Color.GRAY);

        g.fill(engine);

        g.setColor(Color.BLACK);



    }
}
