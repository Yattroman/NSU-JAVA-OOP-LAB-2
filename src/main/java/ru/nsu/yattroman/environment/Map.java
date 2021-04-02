package ru.nsu.yattroman.environment;

public class Map {

    private final int width;
    private final int height;
    private char[][] mapHolder;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        this.mapHolder = new char[width][height];

        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                mapHolder[i][j] = '0';
            }
        }
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
