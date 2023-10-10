package ru.vsu.cs.shul.task1;

import ru.vsu.cs.shul.task1.elements.plane.Elevator;
import ru.vsu.cs.shul.task1.elements.plane.Engine;
import ru.vsu.cs.shul.task1.elements.plane.Orientation;
import ru.vsu.cs.shul.task1.elements.plane.Wings;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class DrawingUtils {
    public static void paintPlane(Graphics2D g, WindowSizeProvider size, double scale, int roll, int x, int y) {

        int h = size.getH();

        int w = size.getW();

        x = w / 2;
        y = h / 2;

        System.out.println("w " + w + " h " + h + " x " + x + " y " + y);


        Wings leftWing = new Wings(w, h, x, y, Orientation.LEFT);

        Wings rightWing = new Wings(w, h, x, y, Orientation.RIGHT);

        leftWing.draw(g);
        rightWing.draw(g);

        g.setColor(Color.BLACK);

        g.fillOval((int) (w * 0.6015), (int) (h * 0.5787), (int) (w * 0.02538), (int) (h * 0.04424));
        g.fillOval((int) (w * 0.37309), (int) (h * 0.5787), (int) (w * 0.02538), (int) (h * 0.04424));

        Engine test = new Engine(w, h, x, y, Orientation.LEFT);
        Engine test2 = new Engine(w, h, x, y, Orientation.RIGHT);
        test.draw(g);
        test2.draw(g);


        GeneralPath fuselage = new GeneralPath();
        fuselage.moveTo(w * 0.5634, h * 0.5079);
        fuselage.lineTo(w * 0.4365, h * 0.5079);
        fuselage.curveTo(w * 0.4365, h * 0.5079, w * 0.4428, h * 0.3044, w * 0.5, h * 0.3044);
        fuselage.moveTo(w * 0.5634, h * 0.5079);
        fuselage.curveTo(w * 0.5634, h * 0.5079, w * 0.5571, h * 0.3044, w * 0.5, h * 0.3044);

        g.setPaint(new LinearGradientPaint((float) (w * 0.5634), y, (float) (w * 0.4365), y,
                new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}, new Color[]{Color.DARK_GRAY, Color.GRAY,
                Color.WHITE, Color.GRAY, Color.DARK_GRAY}, MultipleGradientPaint.CycleMethod.REFLECT));
        g.fill(fuselage);

        g.setColor(Color.GRAY);

        Polygon a = new Polygon();

        a.addPoint((int) (w * 0.5634), (int) (h * 0.5079));
        a.addPoint((int) (w * 0.4365), (int) (h * 0.5079));
        a.addPoint((int) (w * 0.2843), (int) (h * 0.5265));
        a.addPoint((int) (w * 0.7157), (int) (h * 0.5265));

        g.fill(a);

        GeneralPath keel = new GeneralPath();
        keel.moveTo(w * 0.4873, h * 0.5);
        keel.curveTo(w * 0.4873, h * 0.5, w * 0.4873, h * 0.4637, w * 0.4949, h * 0.2513);

        keel.curveTo(w * 0.4949, h * 0.2513 , w * 0.49746, h * 0.1982, w * 0.5, h * 0.2159);
        keel.curveTo(w * 0.5, h * 0.2159, w * 0.5025, h * 0.1982, w * 0.5050, h * 0.2513);
        //keel.lineTo(x + 4, y - 140);

        keel.curveTo(w * 0.5050, h * 0.2513, w * 0.5126, h * 0.4637, w * 0.5126, h * 0.5);
        keel.lineTo(w * 0.5, h * 0.5);

        g.setPaint(new LinearGradientPaint((float) (w * 0.5), (float) (h * 0.2513), (float) (w * 0.5), (float) (h * 0.5),
                new float[]{0.0f, 0.5f, 0.7f}, new Color[]{Color.BLACK, Color.DARK_GRAY, Color.GRAY}));

        g.fill(keel);

        g.setColor(Color.BLACK);

        g.setStroke(new BasicStroke(2));


        g.drawLine((int) (w * 0.5), (int) (h * 0.2513), (int) (w*0.5), (int) (h*0.5));
        g.drawLine((int) (w * 0.4873), (int) (h*0.5), (int) (w * 0.51269), (int) (h*0.5));

        g.setStroke(new BasicStroke(1));


        GeneralPath underKeel = new GeneralPath();

        underKeel.moveTo(w * 0.51269, h * 0.5);
        underKeel.curveTo(w * 0.51269, h * 0.5, w * 0.5152, h * 0.51858, w * 0.538, h * 0.5256);

        underKeel.lineTo(w * 0.538, h * 0.561);
        underKeel.curveTo(w * 0.538, h * 0.561, w * 0.52538, h * 0.5699, w * 0.505, h * 0.57168);

        underKeel.lineTo(w * 0.4949, h * 0.57168);
        underKeel.curveTo(w * 0.4949, h * 0.57168, w * 0.4746, h * 0.5699, w * 0.4619, h * 0.561);

        underKeel.lineTo(w * 0.4619, h * 0.5256);

        underKeel.curveTo(w * 0.4619, h * 0.5256, w * 0.4847, h * 0.5185, w * 0.4873, h * 0.5);

        underKeel.lineTo(w * 0.51269, h * 0.5);



        g.setPaint(new LinearGradientPaint((float) (w * 0.5), (float) (h * 0.5), (float) (w * 0.5), (float) (h * 0.57168),
                new float[]{0.0f, 0.8f, 0.9f}, new Color[]{Color.GRAY, Color.DARK_GRAY, Color.BLACK}));

        g.fill(underKeel);



        g.fillRoundRect((int) (w * 0.4873), (int) (h * 0.5876), (int) (w * 0.02538), (int) (h * 0.0619), 10, 10);
        g.fillRoundRect((int) (w * 0.4949), (int) (h * 0.57168), (int) (w * 0.0101), (int) (h * 0.0159), 2, 2);

        // w 788 h 565 x 394 y 282

        // x = 1/788*y (W)
        // x = 1/565*y (H)

        Elevator rightElevator = new Elevator(w, h, Orientation.RIGHT);
        Elevator leftElevator = new Elevator(w, h, Orientation.LEFT);

        rightElevator.draw(g);
        leftElevator.draw(g);

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


