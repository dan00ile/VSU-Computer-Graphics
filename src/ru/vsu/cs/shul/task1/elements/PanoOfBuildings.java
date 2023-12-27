package ru.vsu.cs.shul.task1.elements;

import ru.vsu.cs.shul.task1.WindowSizeProvider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PanoOfBuildings {

    Random random = new Random();

    private WindowSizeProvider size;

    private List<Building> listOfBuildings = new ArrayList<>();

    public PanoOfBuildings(WindowSizeProvider size) {
        this.size = size;
    }


    private void initList() {



    }

    public void draw(Graphics2D g) {
        if (listOfBuildings.isEmpty()) {
            int w = size.getW();
            int h = size.getH();

            int x = 0;

            while (x < w) {

                int hMax = h / 2;

                int buildW = random.nextInt(w / 3);

                if (buildW < 60) {
                    buildW = 60;
                }

                int buildH = random.nextInt(hMax);

                if (buildH < 60) {
                    buildH = 60;
                }

                listOfBuildings.add(new Building(x, h - buildH, buildW, buildH,new Color(random.nextInt(255),random.nextInt(255), random.nextInt(255)), random.nextBoolean()));

                x += buildW;
            }
            x = w / 6;

            while (x < w) {

                int hMax = h / 2;

                int buildW = random.nextInt(w / 4) + 30;

                if (buildW > 100) {
                    buildW = 100;
                }


                int buildH = random.nextInt(hMax);

                if (buildH < 60) {
                    buildH = 60;
                }


                listOfBuildings.add(new Building(x, h - buildH, buildW, buildH,
                        new Color(random.nextInt(255),random.nextInt(255), random.nextInt(255)), random.nextBoolean()));

                x += buildW;
                x += random.nextInt(100);
            }




            for (Building a : listOfBuildings) {
                a.draw(g);
            }
        } else {
            for (Building a : listOfBuildings) {
                a.draw(g);
            }
        }
    }
}
