package ru.vsu.cs.shul.task1.elements.plane;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class UnderKeel {

    private final int w, h;

    private final int offsetX, offsetY;

    public UnderKeel(int w, int h, int offsetX, int offsetY) {
        this.w = w;
        this.h = h;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public void draw(Graphics2D g) {

        GeneralPath underKeel = new GeneralPath();

        underKeel.moveTo(offsetX + w * 0.51269, offsetY + h * 0.5);
        underKeel.curveTo(offsetX + w * 0.51269, offsetY + h * 0.5, offsetX + w * 0.5152, offsetY + h * 0.51858,
                offsetX + w * 0.538, offsetY + h * 0.5256);

        underKeel.lineTo(offsetX + w * 0.538, offsetY + h * 0.561);
        underKeel.curveTo(offsetX + w * 0.538, offsetY + h * 0.561, offsetX + w * 0.52538, offsetY + h * 0.5699,
                offsetX + w * 0.505, offsetY + h * 0.57168);

        underKeel.lineTo(offsetX + w * 0.4949, offsetY + h * 0.57168);
        underKeel.curveTo(offsetX + w * 0.4949, offsetY + h * 0.57168, offsetX + w * 0.4746, offsetY + h * 0.5699,
                offsetX + w * 0.4619, offsetY + h * 0.561);

        underKeel.lineTo(offsetX + w * 0.4619, offsetY + h * 0.5256);

        underKeel.curveTo(offsetX + w * 0.4619, offsetY + h * 0.5256, offsetX + w * 0.4847, offsetY + h * 0.5185,
                offsetX + w * 0.4873, offsetY + h * 0.5);

        underKeel.lineTo(offsetX + w * 0.51269, offsetY + h * 0.5);

        g.setPaint(new LinearGradientPaint((float) (offsetX + w * 0.5), (float) (offsetY + h * 0.5), (float) (offsetX + w * 0.5), (float) (offsetY + h * 0.57168),
                new float[]{0.0f, 0.8f, 0.9f}, new Color[]{Color.GRAY, Color.DARK_GRAY, Color.BLACK}));

        g.fill(underKeel);

        g.fillRoundRect((int) (offsetX + w * 0.4873), (int) (offsetY + h * 0.5876), (int) (w * 0.02538), (int) (h * 0.0619), 10, 10);
        g.fillRoundRect((int) (offsetX + w * 0.4949), (int) (offsetY + h * 0.57168), (int) (w * 0.0101), (int) (h * 0.0259), 2, 2);

    }
}
