package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Fuselage {

    private final int w, h;

    private final int offsetX, offsetY;

    public Fuselage(int w, int h, int offsetX, int offsetY) {
        this.w = w;
        this.h = h;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }


    public void draw(Graphics2D g) {
        GeneralPath fuselage = new GeneralPath();
        fuselage.moveTo(offsetX + w * 0.5634, offsetY + h * 0.5079);
        fuselage.lineTo(offsetX + w * 0.4365, offsetY + h * 0.5079);
        fuselage.curveTo(offsetX + w * 0.4365, offsetY + h * 0.5079, offsetX + w * 0.4428, offsetY + h * 0.3044, offsetX + w * 0.5, offsetY + h * 0.3044);
        fuselage.moveTo(offsetX + w * 0.5634, offsetY + h * 0.5079);
        fuselage.curveTo(offsetX + w * 0.5634, offsetY + h * 0.5079, offsetX + w * 0.5571, offsetY + h * 0.3044, offsetX + w * 0.5, offsetY + h * 0.3044);

        g.setPaint(new LinearGradientPaint((float) (offsetX + w * 0.4365), (float) (offsetY + h / 2.0), (float) (offsetX + w * 0.5634), offsetY + h/2,
                new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}, new Color[]{Color.DARK_GRAY, Color.GRAY,
                Color.WHITE, Color.GRAY, Color.DARK_GRAY}, MultipleGradientPaint.CycleMethod.REFLECT));
        g.fill(fuselage);

        g.setColor(Color.BLACK);

        g.fillOval((int) (offsetX + w * 0.6015), (int) (offsetY + h * 0.5787), (int) ( w * 0.02538), (int) (h * 0.04424));
        g.fillOval((int) (offsetX + w * 0.37309), (int) (offsetY + h * 0.5787), (int) (w * 0.02538), (int) (h * 0.04424));
    }

}
