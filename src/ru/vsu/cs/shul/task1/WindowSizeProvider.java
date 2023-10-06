package ru.vsu.cs.shul.task1;

public class WindowSizeProvider {
    private int w,h;

    public WindowSizeProvider(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}