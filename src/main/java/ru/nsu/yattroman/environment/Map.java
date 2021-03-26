package ru.nsu.yattroman.environment;

public class Map {
    private int width;
    private int height;
    private Robot robot;
    private char[][] mapHolder;

    public Map(int width, int height, Robot.Coordinates rCoordinates) {
        this.width = width;
        this.height = height;
        this.robot = new Robot(rCoordinates);
        this.mapHolder = new char[width][height];
    }
}
