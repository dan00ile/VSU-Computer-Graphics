package ru.vsu.cs.shul.task1;

import ru.vsu.cs.shul.task1.elements.Building;
import ru.vsu.cs.shul.task1.elements.Moon;
import ru.vsu.cs.shul.task1.elements.Plane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DrawPanel extends JPanel {

    private  WindowSizeProvider size = new WindowSizeProvider(0, 0);

    private Building c,d;
    private Moon b;
    private Plane a;

    public DrawPanel() {

        a = new Plane(size,  0.5 , 1, getWidth() / 2 - 50, getHeight()/2 - 50);

        b = new Moon(size);

        c = new Building(150, 200, 300, 300, Color.GRAY, true);

        d = new Building(500, 200, 300, 300, Color.GRAY, false);


    }




    @Override
    public void paint(Graphics g) {

        /*
        g.setColor(Color.CYAN);
        g.drawLine(10, 10, 200, 100);
        g.drawRect(50, 10, 30, 100);
        g.drawOval(50,10,30,100);
        g.drawArc(50,10,200,100,30,90);



        g.drawString("Some fdgdfsg", 50, 10);
        final int size = 30;
        int[] x = new int[size];
        int [] y = new int[size];
        for (int i = 0; i < size; i++) {
            x[i] = i * 10 + 50;
            y[i] = 100 + (int)(30*Math.sin(i));

        }
        g.drawPolygon(x, y, size);
        // gr.drawPolyLine
         */
        /*
        Polygon s = new Polygon();
        for (int i = 0; i < 50; i++) {
            s.addPoint(i + 50, 100 + (int)(30*Math.sin(i)));

        }
        gr.draw(s);


         */
        /*
        gr.setColor(Color.RED);

        GeneralPath path = new GeneralPath();
        path.moveTo(10, 10);
        path.lineTo(10, 100);
        path.curveTo(30,50,90,80,100,10);
        gr.draw(path);



        for (int i = 0; i < 10; i++) {
            gr.setColor(Color.BLACK);
            gr.setStroke(new BasicStroke(i));
            g.drawLine(100, i*20+30, 200, i*20+35);
        }
        gr.setFont(new Font("Times", Font.PLAIN, 100));
        gr.drawString("SONYA LOX", 200, 200);

        Building a = new Building(100, 300, 50, 50, Color.WHITE);
        a.draw(gr);*/
/*

        Building b = new Building(100, 200, 200, 100, Color.GRAY, true);
        b.draw(gr);

        Building b1 = new Building(500, 200, 100, 100, new Color(94, 18, 18), false);
        b1.draw(gr);


 */



        super.paint(g);
        Graphics2D gr = (Graphics2D) g;

        size.setH(this.getHeight());

        size.setW(this.getWidth());

        g.setColor(new Color(32,103,125));
        g.fillRect(0,0,getWidth(),getHeight());

        c.draw(gr);
        d.draw(gr);


        b.draw(gr);
        a.draw(gr);

    }
}
