package ru.vsu.cs.shul.task1.elements;

import ru.vsu.cs.shul.task1.DrawingUtils;
import ru.vsu.cs.shul.task1.WindowSizeProvider;
import ru.vsu.cs.shul.task1.WindowSizeProviderStaticImpl;

import java.awt.*;

public class Plane {

    private final WindowSizeProvider size;

    private int roll, offsetX, offsetY;

    private double scale;

    private Color colorOfPlane;


    private Color colorOfName;


    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public double getScale() {
        return scale;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

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
