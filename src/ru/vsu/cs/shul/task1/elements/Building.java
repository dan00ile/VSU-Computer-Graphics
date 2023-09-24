package ru.vsu.cs.shul.task1.elements;

import ru.vsu.cs.shul.task1.DrawingUtils;

import java.awt.*;

public class Building {

    private int x,y,w,h;

    private Color c;

    private Boolean isOffice;



    public Building(int x, int y, int w, int h, Color c, Boolean isOffice) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
        this.isOffice = isOffice;
    }

    public void draw(Graphics2D g) {
        DrawingUtils.paintBuilding(g,x,y,w,h,c, isOffice);
    }

}
