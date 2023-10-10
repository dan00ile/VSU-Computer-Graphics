package ru.vsu.cs.shul.task1;

import ru.vsu.cs.shul.task1.elements.Building;
import ru.vsu.cs.shul.task1.elements.Moon;
import ru.vsu.cs.shul.task1.elements.Plane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DrawPanel extends JPanel implements WindowSizeProvider {

    private final Building c,d;
    private final Moon b;
    private Plane a;
    private KeyListener keyListener;




    public DrawPanel() {

        a = new Plane(this,  1 , 1, getWidth() / 2 - 50, getHeight()/2 - 50);

        b = new Moon(this);

        c = new Building(150, 200, 300, 300, Color.GRAY, true);

        d = new Building(500, 200, 300, 300, Color.GRAY, false);

        keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    if (a.getScale() < 1000) {
                        a.setScale(a.getScale()+50);
                        System.out.println("Up");
                    }

                } else if (keyCode == KeyEvent.VK_DOWN) {
                    if (a.getScale() > 0) {
                        a.setScale(a.getScale()-50);
                        System.out.println("Down");
                    }

                }
                repaint();
            }
        };
        addKeyListener(keyListener);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }




    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gr = (Graphics2D) g;


        g.setColor(new Color(32,103,125));
        g.fillRect(0,0,getWidth(),getHeight());

        c.draw(gr);
        d.draw(gr);

        b.draw(gr);
        a.draw(gr);

    }

    @Override
    public int getW() {
        return getWidth();
    }

    @Override
    public int getH() {
        return getHeight();
    }
}
