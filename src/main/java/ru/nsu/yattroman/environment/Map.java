package ru.nsu.yattroman.environment;

public class Map {
    private int width;
    private int height;
    private char[][] mapHolder;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        this.mapHolder = new char[width][height];

        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                mapHolder[i][j] = 0;
            }
        }
    }

    public void showMap(){
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                System.out.print(mapHolder[i][j] + " ");
            }
            System.out.println();
        }
    }
}
