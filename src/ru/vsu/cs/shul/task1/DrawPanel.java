package ru.vsu.cs.shul.task1;

import ru.vsu.cs.shul.task1.elements.Moon;
import ru.vsu.cs.shul.task1.elements.PanoOfBuildings;
import ru.vsu.cs.shul.task1.elements.Plane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel implements WindowSizeProvider, ActionListener {

    private PanoOfBuildings buildings;
    private final Moon b;
    private final Plane a;

    private final Timer timer;

    private double scaleFactor = 0;
    private double rollFactor = 0;


    private boolean flagUp, flagDown, flagLeft, flagRight = false;

    public DrawPanel() {

        timer = new Timer(3, this);
        timer.start();

        a = new Plane(this,  0 , 0, getWidth() / 2 - 50, getHeight()/2 - 50);

        b = new Moon(this);

        buildings = new PanoOfBuildings(this);


        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    flagUp = true;
                    flagDown = false;
                }
                if (keyCode == KeyEvent.VK_DOWN) {
                    flagDown = true;
                    flagUp = false;
                }
                if (keyCode == KeyEvent.VK_LEFT) {
                    flagLeft = true;
                    flagRight = false;
                }
                if (keyCode == KeyEvent.VK_RIGHT) {
                    flagRight = true;
                    flagLeft = false;
                }
                if (keyCode == KeyEvent.VK_ALT) {
                    buildings = new PanoOfBuildings(DrawPanel.this);
                    repaint();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    flagUp = false;
                }
                if (keyCode == KeyEvent.VK_DOWN) {
                    flagDown = false;
                }
                if (keyCode == KeyEvent.VK_LEFT) {
                    flagLeft = false;
                }
                if (keyCode == KeyEvent.VK_RIGHT) {
                    flagRight = false;
                }
            }
        };
        addKeyListener(keyListener);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            a.addTick();
            if (flagLeft) {
                rollFactor -= 0.5;
                a.setRoll(rollFactor);
            }
            if (flagRight) {
                rollFactor += 0.5;
                a.setRoll(rollFactor);
            }
            if (flagDown) {
                if (scaleFactor > 0) {
                    scaleFactor -= 0.1;
                }
                a.setDistance(scaleFactor);
            }
            if (flagUp) {
                scaleFactor += 0.1;
                a.setDistance(scaleFactor);
            }

            repaint();
        }
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gr = (Graphics2D) g;

        g.setColor(new Color(32,103,125));
        g.fillRect(0,0,getWidth(),getHeight());

        buildings.draw(gr);

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
