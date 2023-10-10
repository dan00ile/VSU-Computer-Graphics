package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Wings {

    private final int w,h,x,y;

    private final Orientation or;

    public Wings(int w, int h, int x, int y, Orientation or) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.or = or;
    }



    public void draw(Graphics2D g) {

        // w 788 h 565 x 394 y 282

        // x = 1/788*y (W)
        // x = 1/565*y (H)

        g.setPaint(new LinearGradientPaint(w/2 , h/2, (float) (w/2 + w * 0.444), h/2,
                new float[]{0.2f, 0.5f, 0.6f, 0.7f, 1.0f}, new Color[]{Color.DARK_GRAY, Color.GRAY,
                new Color(148, 143, 143), Color.LIGHT_GRAY, Color.GRAY}, MultipleGradientPaint.CycleMethod.REFLECT));

        int orient = this.or.getCode();

        GeneralPath wing = new GeneralPath();

        wing.moveTo(w/2 + orient * w * 0.05, h/2 - h * 0.053);
        wing.lineTo(w/2 + orient * w * 0.444, h/2 - 0.0884 * h);
        wing.curveTo(w/2 + orient * w * 0.444, h/2 - 0.0884 * h, w/2 + orient * w * 0.4695, h/2 - h * 0.106, w/2 + orient * w * 0.4822, h/2 - h * 0.035);
        wing.lineTo(w/2 + orient * w * 0.05, h/2 + h * 0.0354);

        g.fill(wing);

    }
}
