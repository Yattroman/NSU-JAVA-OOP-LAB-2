package ru.nsu.yattroman.environment;

/**
 * Класс карты, с которой взаимодейтсвует робот
 */
public class Map {

    private final int width;
    private final int height;
    private char[][] mapHolder;
    private Robot robot;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.robot = null;

        this.mapHolder = new char[width][height];

        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                mapHolder[i][j] = '0';
            }
        }
    }

    public Robot getRobot() {
        return robot;
    }
    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMapHolder(){
        return mapHolder;
    }

    public void setCell(Robot.Coordinates coordinates, char cell){
        mapHolder[coordinates.getY()][coordinates.getX()] = cell;
    }
}
