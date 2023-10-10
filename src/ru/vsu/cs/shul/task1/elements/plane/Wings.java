package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Wings {

    private final int w,h,offsetX,offsetY;

    private final Orientation or;

    public Wings(int w, int h, int offsetX, int offsetY, Orientation or) {
        this.w = w;
        this.h = h;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.or = or;
    }



    public void draw(Graphics2D g) {

        g.setPaint(new LinearGradientPaint( offsetX + w/2 , offsetY + h/2, (float) (offsetX + w/2 + w * 0.444), offsetY + h/2,
                new float[]{0.2f, 0.5f, 0.6f, 0.7f, 1.0f}, new Color[]{Color.DARK_GRAY, Color.GRAY,
                new Color(148, 143, 143), Color.LIGHT_GRAY, Color.GRAY}, MultipleGradientPaint.CycleMethod.REFLECT));

        int orient = this.or.getCode();

        GeneralPath wing = new GeneralPath();

        wing.moveTo(offsetX + w/2 + orient * w * 0.05, offsetY + h/2 - h * 0.053);
        wing.lineTo(offsetX + w/2 + orient * w * 0.444, offsetY + h/2 - 0.0884 * h);
        wing.curveTo(offsetX + w/2 + orient * w * 0.444, offsetY + h/2 - 0.0884 * h,
                offsetX + w/2 + orient * w * 0.4695, offsetY + h/2 - h * 0.106, offsetX + w/2 + orient * w * 0.4822, offsetY + h/2 - h * 0.035);
        wing.lineTo(offsetX + w/2 + orient * w * 0.05, offsetY + h/2 + h * 0.0354);

        g.fill(wing);

    }
}
