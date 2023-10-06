package ru.vsu.cs.shul.task1.elements;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Building {

    private final Random random = new Random();

    class Window {
       private final int x, y, size;

       private final boolean sticks;

       private final Color colorL;



        public Window(int x, int y, int size, boolean light, boolean sticks) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.sticks = sticks;

            if (light) {
                this.colorL = new Color(255, 247, 167 + random.nextInt(50));
            } else {
                this.colorL = new Color(41, 45, 56);
            }
        }

        public void draw(Graphics2D g) {

            g.setColor(Color.black);
            g.fillRect(x, y, size, size);

            int k = size / 10;

            g.setColor(colorL);
            g.fillRect(x + k, y + k, size - k * 2, size - k * 2);



            if (sticks) {
                g.setColor(Color.black);
                g.setStroke(new BasicStroke(2));
                g.drawLine(x + 1, y + size / 2, x + size - 1, y + size / 2);
                g.drawLine(x + size / 2, y + 1, x + size / 2, y + size - 1);
            }


        }
    }


    class Brick {
        private final int x,y, w, h;

        public Brick(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
        public void draw(Graphics2D g) {
            g.fillRect(x, y, w, h);
        }
    }

    private final List<Window> listOfW = new ArrayList<>();

    private final List<Brick> listOfB = new ArrayList<>();

    private final int x,y,w,h;

    private final Color c;

    private final Boolean isOffice;



    public Building(int x, int y, int w, int h, Color c, Boolean isOffice) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
        this.isOffice = isOffice;

        initLists();
    }

    private void initLists() {

        if (this.isOffice) {

            int windSize = Math.min(h / 6, w / 6);

            int windLines = (h - 10) / (windSize + 10);
            int windLineCount = (w - 20) / windSize;

            int wSpace = w - (windSize * windLineCount);
            int hSpace = h - (windLines * (windSize + 10));

            for (int i = 1; i <= windLines; i++) {
                for (int j = 1; j <= windLineCount; j++) {
                    listOfW.add(new Window(x + w - wSpace / 2 - j * windSize, y + hSpace / 2 + 10 * (i - 1) + windSize * (i - 1),
                            windSize, random.nextBoolean(), false));
                }
            }
        } else {
            int windSize = Math.min(h / 6, w / 6);

            int windCount = (w - 20) / windSize;

            int space = (w - windCount * windSize) / (windCount + 1);

            for (int i = 1; i <= windCount; i++) {
                listOfW.add(new Window(x + w - space * i - i * windSize,i % 2 == 0 ? y + h / 3 : y + h / 4,
                        windSize, random.nextBoolean(), true));
            }
            int brickCount = random.nextInt(15) + 1;

            for (int i = 0; i < brickCount; i++) {
                int brickHeight = random.nextInt(5) + 5;
                int brickWidth = brickHeight * 2;
                int brickX = random.nextInt(w - brickWidth - 1) + x;
                int brickY = random.nextInt(h / 3 - brickHeight - 1) + y + h * 2 / 3;

                listOfB.add(new Brick(brickX, brickY, brickWidth, brickHeight));
            }
        }
    }

    public void draw(Graphics2D g) {
        paintBuilding(g,x,y,w,h,c, isOffice);
    }

    public void paintBuilding(Graphics2D g, int x, int y, int w, int h, Color color, Boolean isOffice) {
        // Set building color
        g.setColor(color);

        g.fillRoundRect(x, y, w, h, 5, 5);

        g.setPaint(new LinearGradientPaint(x, y - 5, x, y, new float[]{0.1f, 0.9f}, new Color[]{Color.DARK_GRAY, color}));

        g.fillRect(x, y - 5, w, 10);

        g.setColor(Color.LIGHT_GRAY);

        g.fillRoundRect(x - 3, y - 12, w + 6, 7, 2, 2);

        g.setColor(Color.BLACK);

        this.drawWindows(g);
        this.drawRandBricks(g);


    }

    private void drawRandBricks(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);

        for (Brick brick : this.listOfB) {
            brick.draw(g);
        }
    }

    public void drawWindows(Graphics2D g) {

        for (Window window : this.listOfW) {
            window.draw(g);
        }


    }




}
