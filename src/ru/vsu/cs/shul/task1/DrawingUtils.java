package ru.vsu.cs.shul.task1;

import ru.vsu.cs.shul.task1.elements.plane.Elevator;
import ru.vsu.cs.shul.task1.elements.plane.Engine;
import ru.vsu.cs.shul.task1.elements.plane.Orientation;
import ru.vsu.cs.shul.task1.elements.plane.Wings;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class DrawingUtils {
    public static void paintPlane(Graphics2D g, WindowSizeProvider size, double distance, int roll, int offsetX, int offsetY) {


        int h = (int) (size.getH() - size.getH()  * distance/1000) ;

        int w = (int) (size.getW() - size.getW()  * distance/1000);

        offsetX = (size.getW() - w) / 2;
        offsetY = (int) ((size.getH() - h) / 2 - distance/10);

        Wings leftWing = new Wings(w, h, offsetX, offsetY, Orientation.LEFT);

        Wings rightWing = new Wings(w, h, offsetX, offsetY, Orientation.RIGHT);

        leftWing.draw(g);
        rightWing.draw(g);

        g.setColor(Color.BLACK);

        g.fillOval((int) (offsetX + w * 0.6015), (int) (offsetY + h * 0.5787), (int) ( w * 0.02538), (int) (h * 0.04424));
        g.fillOval((int) (offsetX + w * 0.37309), (int) (offsetY + h * 0.5787), (int) (w * 0.02538), (int) (h * 0.04424));

        Engine test = new Engine(w, h, offsetX, offsetY, Orientation.LEFT);
        Engine test2 = new Engine(w, h, offsetX, offsetY, Orientation.RIGHT);
        test.draw(g);
        test2.draw(g);


        GeneralPath fuselage = new GeneralPath();
        fuselage.moveTo(offsetX + w * 0.5634, offsetY + h * 0.5079);
        fuselage.lineTo(offsetX + w * 0.4365, offsetY + h * 0.5079);
        fuselage.curveTo(offsetX + w * 0.4365, offsetY + h * 0.5079, offsetX + w * 0.4428, offsetY + h * 0.3044, offsetX + w * 0.5, offsetY + h * 0.3044);
        fuselage.moveTo(offsetX + w * 0.5634, offsetY + h * 0.5079);
        fuselage.curveTo(offsetX + w * 0.5634, offsetY + h * 0.5079, offsetX + w * 0.5571, offsetY + h * 0.3044, offsetX + w * 0.5, offsetY + h * 0.3044);

        g.setPaint(new LinearGradientPaint((float) (offsetX + w * 0.4365), offsetY + h / 2, (float) (offsetX + w * 0.5634), offsetY + h/2,
                new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}, new Color[]{Color.DARK_GRAY, Color.GRAY,
                Color.WHITE, Color.GRAY, Color.DARK_GRAY}, MultipleGradientPaint.CycleMethod.REFLECT));
        g.fill(fuselage);

        g.setColor(Color.GRAY);

        Polygon a = new Polygon();

        a.addPoint((int) (offsetX + w * 0.5634), (int) (offsetY + h * 0.5079));
        a.addPoint((int) (offsetX + w * 0.4365), (int) (offsetY + h * 0.5079));
        a.addPoint((int) (offsetX + w * 0.2843), (int) (offsetY + h * 0.5265));
        a.addPoint((int) (offsetX + w * 0.7157), (int) (offsetY + h * 0.5265));

        g.fill(a);

        GeneralPath keel = new GeneralPath();
        keel.moveTo(offsetX + w * 0.4873, offsetY + h * 0.5);
        keel.curveTo(offsetX + w * 0.4873, offsetY + h * 0.5, offsetX + w * 0.4873, offsetY + h * 0.4637, offsetX + w * 0.4949, offsetY + h * 0.2513);

        keel.curveTo(offsetX + w * 0.4949, offsetY + h * 0.2513 , offsetX + w * 0.49746, offsetY + h * 0.1982, offsetX + w * 0.5, offsetY + h * 0.2159);
        keel.curveTo(offsetX + w * 0.5, offsetY + h * 0.2159, offsetX + w * 0.5025, offsetY + h * 0.1982, offsetX + w * 0.5050, offsetY + h * 0.2513);
        //keel.lineTo(x + 4, y - 140);

        keel.curveTo(offsetX + w * 0.5050, offsetY + h * 0.2513, offsetX + w * 0.5126, offsetY + h * 0.4637, offsetX + w * 0.5126, offsetY + h * 0.5);
        keel.lineTo(offsetX + w * 0.5, offsetY + h * 0.5);

        g.setPaint(new LinearGradientPaint((float) (offsetX + w * 0.5), (float) (offsetY + h * 0.2513), (float) (offsetX + w * 0.5), (float) (offsetY + h * 0.5),
                new float[]{0.0f, 0.5f, 0.7f}, new Color[]{Color.BLACK, Color.DARK_GRAY, Color.GRAY}));

        g.fill(keel);

        g.setColor(Color.BLACK);

        g.setStroke(new BasicStroke(2));


        g.drawLine((int) (offsetX + w * 0.5), (int) (offsetY + h * 0.2513), (int) (offsetX + w*0.5), (int) (offsetY + h*0.5));
        g.drawLine((int) (offsetX + w * 0.4873), (int) (offsetY + h*0.5), (int) (offsetX + w * 0.51269), (int) (offsetY + h*0.5));

        g.setStroke(new BasicStroke(1));


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
        g.fillRoundRect((int) (offsetX + w * 0.4949), (int) (offsetY + h * 0.57168), (int) ( w * 0.0101), (int) ( h * 0.0259), 2, 2);

        // w 788 h 565 x 394 y 282

        // x = 1/788*y (W)
        // x = 1/565*y (H)

        Elevator rightElevator = new Elevator(w, h, offsetX, offsetY, Orientation.RIGHT);
        Elevator leftElevator = new Elevator(w, h, offsetX, offsetY, Orientation.LEFT);

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


