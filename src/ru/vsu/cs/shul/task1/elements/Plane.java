package ru.vsu.cs.shul.task1.elements;

import ru.vsu.cs.shul.task1.DrawingUtils;
import ru.vsu.cs.shul.task1.WindowSizeProvider;

import java.awt.*;

public class Plane {

    private WindowSizeProvider size;

    private int roll, x, y, w, h;

    private double scale;

    private Color colorOfPlane, colorOfName;


    public Plane(WindowSizeProvider size, double scale, int roll, int x, int y) {
        this.size = size;
        this.scale = scale;
        this.roll = roll;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        DrawingUtils.paintPlane(g, size, scale, roll, x, y);
    }
}
