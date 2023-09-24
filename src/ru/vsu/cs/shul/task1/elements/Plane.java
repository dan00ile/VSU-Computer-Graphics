package ru.vsu.cs.shul.task1.elements;

import ru.vsu.cs.shul.task1.DrawingUtils;

import java.awt.*;

public class Plane {

    private int x, y, scale, pitch, roll;

    private Color colorOfPlane, colorOfName;


    public Plane(int x, int y, int scale, int pitch, int roll) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.pitch = pitch;
        this.roll = roll;
    }

    public void draw(Graphics2D g) {
        DrawingUtils.paintPlane(g, x, y, scale, pitch, roll, colorOfPlane, colorOfName);
    }
}
