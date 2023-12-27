package ru.vsu.cs.shul.task1.elements;

import ru.vsu.cs.shul.task1.WindowSizeProvider;
import ru.vsu.cs.shul.task1.elements.plane.*;

import java.awt.*;

public class Plane {

    private final WindowSizeProvider size;
    private double roll;
    private int offsetX;
    private int offsetY;

    private int ticksFromStart = 0;

    private double distance;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = Math.max(0, Math.min(62, distance));
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public Plane(WindowSizeProvider size, double scale, int roll, int offsetX, int offsetY) {
        this.size = size;
        this.distance = scale;
        this.roll = roll;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }


    public void addTick() {
        ticksFromStart++;
    }

    public void draw(Graphics2D g) {
        double coef = 1 - Math.exp(-distance * 1 / 10);


        int w = (int) (size.getW() - size.getW() * coef);
        int h = (int) (size.getH() - size.getH() * coef);

        offsetX = ((size.getW() - w) / 2);
        offsetY = (int) ((size.getH() - h) / 2 - distance * 2) ;

        g.rotate(roll / 180.0 * Math.PI, offsetX + w * 0.5, offsetY + h * 0.5);

        Engine engineLeft = new Engine(w, h, offsetX, offsetY, Orientation.LEFT, ticksFromStart);
        Engine engineRight = new Engine(w, h, offsetX, offsetY, Orientation.RIGHT, ticksFromStart);

        Wings leftWing = new Wings(w, h, offsetX, offsetY, Orientation.LEFT);

        Wings rightWing = new Wings(w, h, offsetX, offsetY, Orientation.RIGHT);

        Fuselage fuselage = new Fuselage(w, h, offsetX, offsetY);

        Keel keel = new Keel(w, h, offsetX, offsetY);

        UnderKeel underkeel = new UnderKeel(w, h, offsetX, offsetY);

        Elevator rightElevator = new Elevator(w, h, offsetX, offsetY, Orientation.RIGHT);
        Elevator leftElevator = new Elevator(w, h, offsetX, offsetY, Orientation.LEFT);

        engineLeft.draw(g);
        engineRight.draw(g);

        leftWing.draw(g);
        rightWing.draw(g);

        fuselage.draw(g);

        keel.draw(g);

        underkeel.draw(g);

        rightElevator.draw(g);
        leftElevator.draw(g);
    }
}
