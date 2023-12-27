package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Wings {

    private final int w, h, offsetX, offsetY;

    private final Orientation or;

    public Wings(int w, int h, int offsetX, int offsetY, Orientation or) {
        this.w = w;
        this.h = h;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.or = or;
    }


    public void draw(Graphics2D g) {

        g.setPaint(new LinearGradientPaint((float) (offsetX + w / 2.0), (float) (offsetY + h / 2.0), (float) (offsetX + w / 2.0 + w * 0.444), (float) (offsetY + h / 2.0),
                new float[]{0.2f, 0.5f, 0.6f, 0.7f, 1.0f}, new Color[]{Color.DARK_GRAY, Color.GRAY,
                new Color(148, 143, 143), Color.LIGHT_GRAY, Color.GRAY}, MultipleGradientPaint.CycleMethod.REFLECT));

        int orient = this.or.getCode();

        GeneralPath wing = new GeneralPath();

        wing.moveTo(offsetX + w / 2.0 + orient * w * 0.05, offsetY + h / 2.0 - h * 0.053);
        wing.lineTo(offsetX + w / 2.0 + orient * w * 0.444, offsetY + h / 2.0 - 0.0884 * h);
        wing.curveTo(offsetX + w / 2.0 + orient * w * 0.444, offsetY + h / 2.0 - 0.0884 * h,
                offsetX + w / 2.0 + orient * w * 0.4695, offsetY + h / 2.0 - h * 0.106, offsetX + w / 2.0 + orient * w * 0.4822, offsetY + h / 2.0 - h * 0.035);
        wing.lineTo(offsetX + w / 2.0 + orient * w * 0.05, offsetY + h / 2.0 + h * 0.0354);

        g.fill(wing);

    }
}
