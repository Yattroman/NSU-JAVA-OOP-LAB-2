package ru.nsu.yattroman.environment;

public class Map {
    private int width;
    private int height;
    private Robot robot;

    public Map(int width, int height, Robot robot) {
        this.width = width;
        this.height = height;
        this.robot = robot;
    }
}
