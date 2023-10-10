package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Elevator {


    private int w, h;

    private Orientation or;


    public Elevator(int w, int h, Orientation or) {
        this.w = w;
        this.h = h;
        this.or = or;
    }

    public void draw(Graphics2D g) {
        int minOrient = this.or.getCode();


        GeneralPath elevator = new GeneralPath();
        elevator.moveTo(w * 0.5 + minOrient * 0.038 * w, h * 0.5 + h * 0.0265);
        elevator.lineTo(w * 0.5 + minOrient * 0.2157 * w, h * 0.5 + h * 0.0265);
        elevator.lineTo(w * 0.5 + minOrient * 0.2157 * w, h * 0.5 + h * 0.0442);
        elevator.curveTo(w * 0.5 + minOrient * 0.2157 * w, h * 0.5 + h * 0.0442, w * 0.5 + minOrient * w * 0.21319,
                h * 0.5 + h * 0.115, w * 0.5 + minOrient * w * 0.15228, h * 0.5 + h * 0.10796);
        elevator.lineTo(w * 0.5 + minOrient * 60, h * 0.5 + 61);
        elevator.curveTo(w * 0.5 + minOrient * 60, h * 0.5 + 61, w * 0.5 + minOrient * 50,
                h * 0.5 + 60, w * 0.5 + minOrient * 40, h * 0.5 + 41);
        elevator.lineTo(w * 0.5 + minOrient * 0.038 * w, h * 0.5 + 41);
        elevator.lineTo(w * 0.5 + minOrient * 0.038 * w, h * 0.5 + 15);


        g.setPaint(new LinearGradientPaint((float) (w * 0.5), (float) (h * 0.5 + h * 0.0265), (float) (w * 0.5 + 0.71573 * w), (float) (h * 0.5 + h * 0.0265),
                new float[]{0.0f, 0.3f, 0.5f, 0.7f, 1.0f}, new Color[]{Color.GRAY, Color.white, new Color(215, 215, 215), Color.white, Color.GRAY}, MultipleGradientPaint.CycleMethod.REFLECT));
        g.fill(elevator);

        g.setColor(Color.BLACK);
        g.draw(elevator);

    }
}
