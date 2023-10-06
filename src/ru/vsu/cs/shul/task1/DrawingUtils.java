package ru.vsu.cs.shul.task1;

import ru.vsu.cs.shul.task1.elements.plane.Engine;
import ru.vsu.cs.shul.task1.elements.plane.Orientation;
import ru.vsu.cs.shul.task1.elements.plane.Wings;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.Random;

public class DrawingUtils {

    private static Random random = new Random();



    public static void paintPlane(Graphics2D g, WindowSizeProvider size, double scale, int roll, int x, int y) {

        // w = 750 h = 550 x = 350 y = 250
        // x = 394 y == 282

        int h = size.getH();

        int w = size.getW();

        x = w / 2;
        y = h / 2;

        Wings leftWing = new Wings(w, h, x, y, Orientation.LEFT);

        Wings rightWing = new Wings(w, h, x, y, Orientation.RIGHT);

        leftWing.draw(g);
        rightWing.draw(g);

        g.setColor(Color.BLACK);

        g.fillOval(x + 80, y + 45, 20,25);
        g.fillOval(x - 100, y + 45, 20,25);

        Engine test = new Engine(w, h, x, y, Orientation.LEFT);
        Engine test2 = new Engine(w, h, x, y, Orientation.RIGHT);
        test.draw(g);
        test2.draw(g);

        // engine.lineTo((x + 85) + 60 * -Math.cos(Math.PI/6), (y - 30) + 60 * -Math.sin(Math.PI/6));

        GeneralPath fuselage = new GeneralPath();
        fuselage.moveTo(x + 50, y + 5);
        fuselage.lineTo(x - 50, y + 5);
        fuselage.curveTo(x - 50, y + 5, x - 45, y - 110, x, y - 100);
        fuselage.moveTo(x + 50, y + 5);
        fuselage.curveTo(x + 50, y + 5, x + 45, y - 110, x, y - 100);

        g.setPaint(new LinearGradientPaint(x - 50, y, x + 50, y,
                new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}, new Color[]{Color.DARK_GRAY, Color.GRAY,
                Color.WHITE, Color.GRAY, Color.DARK_GRAY}, MultipleGradientPaint.CycleMethod.REFLECT));
        g.fill(fuselage);

        g.setColor(Color.GRAY);

        Polygon a = new Polygon();

        a.addPoint(x + 50, y + 5);
        a.addPoint(x - 50, y + 5);
        a.addPoint(x - 170, y + 15);
        a.addPoint(x + 170, y + 15);

        g.fill(a);

        // w = 750 h = 550 x = 350 y = 250
        // x = 394 y == 282

        GeneralPath keel = new GeneralPath();
        keel.moveTo(x - 10, y);
        keel.curveTo(x - 10, y, x - 10, y - 20, x - 4, y - 140);

        keel.curveTo(x - 4, y - 140 , x - 2, y - 170, x, y - 160);
        keel.curveTo(x, y - 160, x +2, y - 170, x + 4, y - 140);
        //keel.lineTo(x + 4, y - 140);

        keel.curveTo(x + 4, y - 140, x + 10, y - 20, x + 10, y);
        keel.lineTo(x, y);

        g.setPaint(new LinearGradientPaint(x, y - 140, x, y,
                new float[]{0.0f, 0.5f, 0.7f}, new Color[]{Color.BLACK, Color.DARK_GRAY, Color.GRAY}));

        g.fill(keel);

        g.setColor(Color.BLACK);

        g.setStroke(new BasicStroke(2));

        g.drawLine(x, y - 140, x, y);
        g.drawLine(x - 10, y, x + 10, y);

        g.setStroke(new BasicStroke(1));

        //g.fillOval(x - 4, (int) (0.272 * h - 10), (int) (0.013 * w), 20);

        GeneralPath underKeel = new GeneralPath();
        underKeel.moveTo(x + 10, y);
        underKeel.curveTo(x + 10, y, x + 12, y + 11, x + 30, y + 15);

        underKeel.lineTo(x + 30, y + 35);
        underKeel.curveTo(x + 30, y + 35, x + 20, y + 40, x + 4, y + 41);

        underKeel.lineTo(x - 4, y + 41);
        underKeel.curveTo(x - 4, y + 41, x - 20, y + 40, x - 30, y + 35);

        underKeel.lineTo(x - 30, y + 15);

        underKeel.curveTo(x - 30, y + 15, x - 12, y + 11, x - 10, y);

        underKeel.lineTo(x + 10, y);

        g.setPaint(new LinearGradientPaint(x, y, x, y + 41,
                new float[]{0.0f, 0.8f, 0.9f}, new Color[]{Color.GRAY, Color.DARK_GRAY, Color.BLACK}));

        g.fill(underKeel);


        g.fillRoundRect(x - 10, y + 50, 20, 35, 10, 10);
        g.fillRoundRect(x - 4, y + 41, 8, 9, 2, 2);


        GeneralPath rightElevator = new GeneralPath();
        rightElevator.moveTo(x + 30, y + 15);
        rightElevator.lineTo(x + 170, y + 15);
        rightElevator.lineTo(x + 170, y + 25);
        rightElevator.curveTo(x + 170, y + 25, x + 168, y + 65, x + 120, y + 61);
        rightElevator.lineTo(x + 60, y + 61);
        rightElevator.curveTo(x + 60, y + 61, x + 50, y + 60, x + 40, y + 41);
        rightElevator.lineTo(x + 30, y + 41);
        rightElevator.lineTo(x + 30, y + 15);


        g.setPaint(new LinearGradientPaint(x, y + 15, x + 170, y + 15,
                new float[]{0.0f, 0.3f, 0.5f, 0.7f, 1.0f}, new Color[]{Color.GRAY, Color.white, new Color(215, 215, 215), Color.white, Color.GRAY}, MultipleGradientPaint.CycleMethod.REFLECT));
        g.fill(rightElevator);


        GeneralPath leftElevator = new GeneralPath();
        leftElevator.moveTo(x - 30, y + 41);
        leftElevator.lineTo(x - 30, y + 15);
        leftElevator.lineTo(x - 170, y + 15);
        leftElevator.lineTo(x - 170, y + 25);
        leftElevator.curveTo(x - 170, y + 25, x - 168, y + 65, x - 120, y + 61);
        leftElevator.lineTo(x - 60, y + 61);
        leftElevator.curveTo(x - 60, y + 61, x - 50, y + 60, x - 40, y + 41);
        leftElevator.lineTo(x - 30, y + 41);

        g.fill(leftElevator);

        g.setColor(Color.BLACK);
        g.draw(rightElevator);
        g.draw(leftElevator);
    }


    public static void paintMoon(Graphics2D g, WindowSizeProvider size) {

        int w = size.getW();

        float[] dist = {0.0f, 0.1f, 1.0f};
        Color[] colors = {new Color(255, 247, 171),new Color(255, 247, 171, 179),new Color(255, 247, 171, 0) };

        g.setPaint(new RadialGradientPaint((float) (w / 2), 80, (float) (w * 0.45), dist, colors));


        g.fillOval(0, -w /3, w, w);

        g.setColor(new Color(216, 225, 242));
        g.fillOval(w / 4, -w / 5, w / 2, w / 2);
        g.setColor(new Color(234, 241, 249));
        g.fillOval(w / 4 + w / 16, -w / 6, (int) (w * 0.4375), (int) (w * 0.4375));
        g.setColor(new Color(254, 254, 254));
        g.fillOval(w / 4 + w / 7, -w / 6, w / 3, w / 3);

        g.setColor(new Color(165, 186, 227, 137));

        g.fillOval(w / 4 + w / 7, w / 10, w / 18, w / 18);




    }
}


