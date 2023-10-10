package ru.vsu.cs.shul.task1;

public class WindowSizeProviderStaticImpl implements WindowSizeProvider
{
    private int w,h;

    public WindowSizeProviderStaticImpl(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public int getW() {
        return w;
    }

    @Override
    public int getH() {
        return h;
    }
}