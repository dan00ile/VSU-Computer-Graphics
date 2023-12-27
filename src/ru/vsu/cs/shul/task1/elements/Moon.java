package ru.vsu.cs.shul.task1.elements;

import ru.vsu.cs.shul.task1.WindowSizeProvider;

import java.awt.*;

public class Moon {

    private WindowSizeProvider size;

    public Moon(WindowSizeProvider size) {
        this.size = size;
    }

    public void draw(Graphics2D g) {
        int w = size.getW();

        float[] dist = {0.0f, 0.1f, 1.0f};
        Color[] colors = {new Color(255, 247, 171), new Color(255, 247, 171, 179), new Color(255, 247, 171, 0)};

        g.setPaint(new RadialGradientPaint((float) (w / 2.0), 80, (float) (w * 0.45), dist, colors));


        g.fillOval(0, -w / 3, w, w);

        g.setColor(new Color(216, 225, 242));
        g.fillOval(w / 4, -w / 5, (int) (w / 2.0), (int) (w / 2.0));
        g.setColor(new Color(234, 241, 249));
        g.fillOval(w / 4 + w / 16, -w / 6, (int) (w * 0.4375), (int) (w * 0.4375));
        g.setColor(new Color(254, 254, 254));
        g.fillOval(w / 4 + w / 7, -w / 6, w / 3, w / 3);

        g.setColor(new Color(165, 186, 227, 137));

        g.fillOval(w / 4 + w / 7, w / 10, w / 18, w / 18);
    }
}
