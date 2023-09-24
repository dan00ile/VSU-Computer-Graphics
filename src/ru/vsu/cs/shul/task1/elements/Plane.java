package ru.vsu.cs.shul.task1.elements;

import ru.vsu.cs.shul.task1.DrawingUtils;

import java.awt.*;

public class Plane {

    private int roll, w, h;

    private double scale;

    private Color colorOfPlane, colorOfName;


    public Plane(int w, int h, double scale, int roll) {
        this.w = w;
        this.h = h;
        this.scale = scale;
        this.roll = roll;
    }

    public void draw(Graphics2D g) {
        DrawingUtils.paintPlane(g, w, h, scale, roll, colorOfPlane, colorOfName);
    }
}
