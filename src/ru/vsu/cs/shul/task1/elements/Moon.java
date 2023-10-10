package ru.vsu.cs.shul.task1.elements;

import ru.vsu.cs.shul.task1.DrawingUtils;
import ru.vsu.cs.shul.task1.WindowSizeProvider;
import ru.vsu.cs.shul.task1.WindowSizeProviderStaticImpl;

import java.awt.*;

public class Moon {

    private WindowSizeProvider size;

    public Moon(WindowSizeProvider size) {
        this.size = size;
    }

    public void draw(Graphics2D g) {
        DrawingUtils.paintMoon(g, size);
    }
}
