package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Elevator {


    private int w, h, offsetX, offsetY;

    private Orientation or;


    public Elevator(int w, int h, int offsetX, int offsetY, Orientation or) {
        this.w = w;
        this.h = h;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.or = or;
    }

    public void draw(Graphics2D g) {
        int minOrient = this.or.getCode();


        GeneralPath elevator = new GeneralPath();
        elevator.moveTo(offsetX + w * 0.5 + minOrient * 0.038 * w, offsetY + h * 0.5 + h * 0.0265);
        elevator.lineTo(offsetX + w * 0.5 + minOrient * 0.2157 * w, offsetY + h * 0.5 + h * 0.0265);
        elevator.lineTo(offsetX + w * 0.5 + minOrient * 0.2157 * w, offsetY + h * 0.5 + h * 0.0442);
        elevator.curveTo(offsetX + w * 0.5 + minOrient * 0.2157 * w, offsetY + h * 0.5 + h * 0.0442, offsetX + w * 0.5 + minOrient * w * 0.21319,
                offsetY + h * 0.5 + h * 0.115, offsetX + w * 0.5 + minOrient * w * 0.15228, offsetY + h * 0.5 + h * 0.10796);

        // w 788 h 565 x 394 y 282

        // x = 1/788*y (W)
        // x = 1/565*y (H)

        elevator.lineTo(offsetX + w * 0.5 + minOrient * w * 0.0761, offsetY + h * 0.5 + h * 0.1079);
        elevator.curveTo(offsetX + w * 0.5 + minOrient * w * 0.0761, offsetY + h * 0.5 + h * 0.10796, offsetX + w * 0.5 + minOrient * w * 0.0635,
                offsetY + h * 0.5 + h * 0.1062, offsetX + w * 0.5 + minOrient * w * 0.051, offsetY + h * 0.5 + h * 0.0725);
        elevator.lineTo(offsetX + w * 0.5 + minOrient * 0.038 * w, offsetY + h * 0.5 + h * 0.0726);
        elevator.lineTo(offsetX + w * 0.5 + minOrient * 0.038 * w, offsetY + h * 0.5 + h * 0.0265);


        g.setPaint(new LinearGradientPaint((float) (offsetX + w * 0.5), (float) (offsetY + h * 0.5 + h * 0.0265), (float) (offsetX + w * 0.5 + 0.71573 * w), (float) (offsetY + h * 0.5 + h * 0.0265),
                new float[]{0.0f, 0.3f, 0.5f, 0.7f, 1.0f}, new Color[]{Color.GRAY, Color.white, new Color(215, 215, 215), Color.white, Color.GRAY}, MultipleGradientPaint.CycleMethod.REFLECT));
        g.fill(elevator);

        g.setColor(Color.BLACK);
        g.draw(elevator);

    }
}
