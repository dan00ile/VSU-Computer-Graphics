package ru.vsu.cs.shul.task1.elements.plane;

public enum Orientation {
    LEFT(-1),
    RIGHT(1);

    private final int code;

    Orientation(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}