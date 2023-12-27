package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Keel {


    private final int w, h;

    private final int offsetX, offsetY;

    public Keel(int w, int h, int offsetX, int offsetY) {
        this.w = w;
        this.h = h;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }


    public void draw(Graphics2D g) {
        g.setColor(Color.GRAY);

        Polygon a = new Polygon();

        a.addPoint((int) (offsetX + w * 0.5634), (int) (offsetY + h * 0.5079));
        a.addPoint((int) (offsetX + w * 0.4365), (int) (offsetY + h * 0.5079));
        a.addPoint((int) (offsetX + w * 0.2843), (int) (offsetY + h * 0.5265));
        a.addPoint((int) (offsetX + w * 0.7157), (int) (offsetY + h * 0.5265));

        g.fill(a);

        GeneralPath keel = new GeneralPath();
        keel.moveTo(offsetX + w * 0.4873, offsetY + h * 0.5);
        keel.curveTo(offsetX + w * 0.4873, offsetY + h * 0.5, offsetX + w * 0.4873, offsetY + h * 0.4637, offsetX + w * 0.4949, offsetY + h * 0.2513);

        keel.curveTo(offsetX + w * 0.4949, offsetY + h * 0.2513 , offsetX + w * 0.49746, offsetY + h * 0.1982, offsetX + w * 0.5, offsetY + h * 0.2159);
        keel.curveTo(offsetX + w * 0.5, offsetY + h * 0.2159, offsetX + w * 0.5025, offsetY + h * 0.1982, offsetX + w * 0.5050, offsetY + h * 0.2513);


        keel.curveTo(offsetX + w * 0.5050, offsetY + h * 0.2513, offsetX + w * 0.5126, offsetY + h * 0.4637, offsetX + w * 0.5126, offsetY + h * 0.5);
        keel.lineTo(offsetX + w * 0.5, offsetY + h * 0.5);

        g.setPaint(new LinearGradientPaint((float) (offsetX + w * 0.5), (float) (offsetY + h * 0.2513), (float) (offsetX + w * 0.5), (float) (offsetY + h * 0.5),
                new float[]{0.0f, 0.5f, 0.7f}, new Color[]{Color.BLACK, Color.DARK_GRAY, Color.GRAY}));

        g.fill(keel);

        g.setColor(Color.BLACK);

        g.setStroke(new BasicStroke(2));


        g.drawLine((int) (offsetX + w * 0.5), (int) (offsetY + h * 0.2513), (int) (offsetX + w*0.5), (int) (offsetY + h*0.5));
        g.drawLine((int) (offsetX + w * 0.4873), (int) (offsetY + h*0.5), (int) (offsetX + w * 0.51269), (int) (offsetY + h*0.5));

        g.setStroke(new BasicStroke(1));
    }
}
