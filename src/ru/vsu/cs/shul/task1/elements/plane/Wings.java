package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Wings {

    private int w,h,x,y;

    private Orientation or;

    public Wings(int w, int h, int x, int y, Orientation or) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.or = or;
    }



    public void draw(Graphics2D g) {

        g.setPaint(new LinearGradientPaint(x , y, x + 350, y,
                new float[]{0.2f, 0.5f, 0.6f, 0.7f, 1.0f}, new Color[]{Color.DARK_GRAY, Color.GRAY, new Color(148, 143, 143), Color.LIGHT_GRAY, Color.GRAY}, MultipleGradientPaint.CycleMethod.REFLECT));


        int orient = this.or.getCode();


        GeneralPath wing = new GeneralPath();

        wing.moveTo(x + orient * 40, y - 30);
        wing.lineTo(x + orient * 350, y - 50);
        wing.curveTo(x + orient * 350, y - 50, x + orient * 370, y - 60, x + orient * 380, y - 20);
        wing.lineTo(x + orient * 40, y + 20);

        g.fill(wing);

    }
}
