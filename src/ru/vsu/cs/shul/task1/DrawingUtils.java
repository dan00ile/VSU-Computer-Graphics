package ru.vsu.cs.shul.task1;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.Random;

public class DrawingUtils {

    private static Random random = new Random();

    public static void paintBuilding(Graphics2D g, int x, int y, int w, int h, Color color, Boolean isOffice) {


        // Set building color
        g.setColor(color);

        g.fillRoundRect(x, y, w, h, 5, 5);

        g.setPaint(new LinearGradientPaint(x, y - 5, x, y, new float[]{0.1f, 0.9f}, new Color[]{Color.DARK_GRAY, color}));

        g.fillRect(x, y - 5, w, 10);

        g.setColor(Color.LIGHT_GRAY);

        g.fillRoundRect(x - 3, y - 12, w + 6, 7, 2, 2);

        g.setColor(Color.BLACK);


        if (isOffice) {
            int windSize = Math.min(h / 6, w / 6);

            int windLines = (h - 10) / (windSize + 10);
            int windLineCount = (w - 20) / windSize;

            int wSpace = w - (windSize * windLineCount);
            int hSpace = h - (windLines*(windSize + 10));

            for (int i = 1; i <= windLines; i++) {
                for (int j = 1; j <= windLineCount; j++) {
                    drawWindow(g, x + w - wSpace/2 - j * windSize, y + hSpace/2 + 10 * (i-1) + windSize * (i - 1),
                            windSize, windSize, random.nextBoolean(), false);
                }
            }
        } else {

            int windSize = Math.min(h / 6, w / 6);

            int windCount = (w - 20) / windSize;

            int space = (w - windCount * windSize) / (windCount + 1);
            for (int i = 1; i <= windCount; i++) {
                drawWindow(g, x + w - space * i - i * windSize, i % 2 == 0 ? y + h / 3 : y + h / 4, windSize, windSize, random.nextBoolean(), true);
            }

            drawRandBricks(g, x, y, w, h);
        }


    }

    private static void drawRandBricks(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(Color.DARK_GRAY);


        int brickCount = random.nextInt(15) + 1;


        for (int i = 0; i < brickCount; i++) {
            int brickHeight = random.nextInt(5) + 5;
            int brickWidth = brickHeight * 2;
            int brickX = random.nextInt(w - brickWidth - 1) + x;
            int brickY = random.nextInt(h / 3 - brickHeight - 1) + y + h * 2 / 3;

            g.setColor(Color.DARK_GRAY);

            g.fillRect(brickX, brickY, brickWidth, brickHeight);
        }
    }

    public static void drawWindow(Graphics2D g, int x, int y, int w, int h, boolean light, boolean sticks) {
        g.setColor(Color.black);
        g.fillRect(x, y, w, h);

        int k = w / 10;


        if (light) {
            g.setColor(new Color(255, 247, 167 + random.nextInt(50)));
            g.fillRect(x + k, y + k, w - k * 2, h - k * 2);
        } else {
            g.setColor(new Color(41, 45, 56));
            g.fillRect(x + k, y + k, w - k * 2, h - k * 2);
        }

        if (sticks) {
            g.setColor(Color.black);
            g.setStroke(new BasicStroke(2));
            g.drawLine(x + 1, y + h / 2, x + w - 1, y + h / 2);
            g.drawLine(x + w / 2, y + 1, x + w / 2, y + h - 1);
        }


    }


    public static void paintPlane(Graphics2D g, int w, int h, double scale, int roll, Color colorOfPlane, Color colorOfName) {

        // Рисуем хвост
        // w = 750 h = 550 x = 350 y = 250
        GeneralPath path = new GeneralPath();
        path.moveTo(x - 10, y);
        path.curveTo(x - 10, y, x - 10, y - 20, x - 4, y - 100);
        path.lineTo(x + 4, y - 100);
        path.curveTo(x + 4, y - 100, x + 10, y - 20, x + 10, y);
        path.lineTo(x - 10, y);
        g.fill(path);


        g.fillOval(x - 4, y - 100 - 10, 8, 20);


        path.moveTo(x + 10, y);
        path.curveTo(x + 10, y, x + 12, y + 11, x + 30, y + 15);
        path.lineTo(x + 170, y + 15);
        path.lineTo(x + 170, y + 25);
        path.curveTo(x + 170, y + 25, x + 168, y + 65, x + 120, y + 61);
        path.lineTo(x + 60, y + 61);
        path.curveTo(x + 60, y + 61, x + 50, y + 60, x + 40, y + 41);
        path.lineTo(x + 30, y + 41);
        path.lineTo(x + 30, y + 15);

        path.moveTo(x+ 30, y + 35);
        path.curveTo(x + 30, y + 35, x + 20, y + 40, x + 4, y + 41 );

        g.fillRoundRect(x-8, y+50, 16, 25, 10, 10);
        g.fillRoundRect(x-4, y + 41, 8,9,2,2);

        path.moveTo(x - 4, y + 41);
        path.curveTo(x - 4, y + 41, x - 20, y + 40, x - 30, y + 35);

        path.moveTo(x - 30, y + 41);
        path.lineTo(x - 30, y + 15);




        g.draw(path);












    }


}
