package ru.vsu.cs.shul.task1.elements;

import ru.vsu.cs.shul.task1.DrawingUtils;
import ru.vsu.cs.shul.task1.WindowSizeProvider;

import java.awt.*;

public class Plane {

    private final WindowSizeProvider size;

    private final int roll, offsetX, offsetY;

    private final double scale;

    private Color colorOfPlane, colorOfName;

    public Plane(WindowSizeProvider size, double scale, int roll, int offsetX, int offsetY) {
        this.size = size;
        this.scale = scale;
        this.roll = roll;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public void draw(Graphics2D g) {
        DrawingUtils.paintPlane(g, size, scale, roll, offsetX, offsetY);
    }
}
