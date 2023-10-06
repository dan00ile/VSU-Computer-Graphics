package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Engine {

    private int w,h,x,y;

    private Orientation or;

    public Engine(int w, int h, int x, int y, Orientation or) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.or = or;
    }


    public void draw(Graphics2D g) {

        int minOrient = this.or.getCode();

        int minus = 1;

        g.setColor(Color.BLACK);

        for (int i = 0; i < 2; i++) {
            minus *= -1;

            GeneralPath screw = new GeneralPath();

            screw.moveTo((x + minOrient * 85) + 20 * minus * Math.cos(Math.PI/6), (y - 30) + 20 * -Math.sin(Math.PI/6));

            screw.curveTo((x + minOrient * 85) + 20 * minus * Math.cos(Math.PI/6), (y - 30) + 20 * -Math.sin(Math.PI/6),
                    (x + minOrient * 85) + 50 * minus * Math.cos(Math.PI/10), (y - 30) + 50 * -Math.sin(Math.PI/10),
                    (x + minOrient * 85) + 70 * minus * Math.cos(Math.PI/5), (y - 30) + 70 * -Math.sin(Math.PI/5));

            screw.curveTo((x + minOrient * 85) + 70 * minus * Math.cos(Math.PI/5), (y - 30) + 70 * -Math.sin(Math.PI/5),
                    (x + minOrient * 85) + 50 * minus * Math.cos(Math.PI*0.3), (y - 30) + 50 * -Math.sin(Math.PI*0.3),
                    (x + minOrient * 85) + 20 * minus * Math.cos(Math.PI/5), (y - 30) + 20 * -Math.sin(Math.PI/5));

            g.fill(screw);


        }

        GeneralPath engine = new GeneralPath();

        engine.moveTo(x + minOrient * 82, y - 12);
        engine.lineTo(x + minOrient * 60, y - 30);
        engine.curveTo(x + minOrient * 60, y - 30, x + minOrient * 65, y -50, x + minOrient * 80, y - 55);
        engine.lineTo( x + minOrient * 90, y - 55);
        engine.curveTo(x + minOrient * 90, y - 55, x + minOrient * 105, y - 50, x + minOrient * 110, y - 30);
        engine.lineTo( x + minOrient * 88, y - 12);
        engine.lineTo(x + minOrient * 82, y - 12);

        g.setColor(Color.GRAY);

        g.fill(engine);

        g.setColor(Color.BLACK);



    }
}
