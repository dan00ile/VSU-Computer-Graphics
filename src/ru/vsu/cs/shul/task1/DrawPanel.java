package ru.vsu.cs.shul.task1;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    public DrawPanel() {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gr = (Graphics2D) g;
        g.setColor(Color.CYAN);
        g.drawLine(10, 10, 200, 100);
        g.drawRect(50, 10, 30, 100);
        g.drawOval(50,10,30,100);
        g.drawArc(50,10,200,100,30,90);

/*

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

         */

        for (int i = 0; i < 10; i++) {
            gr.setColor(Color.BLACK);
            gr.setStroke(new BasicStroke(i));
            g.drawLine(100, i*20+30, 200, i*20+35);
        }

        // gr.setFont
    }
}