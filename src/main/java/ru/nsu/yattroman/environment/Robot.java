package ru.nsu.yattroman.environment;

public class Robot {
    private Coordinates currentCoordinates;
    private boolean painterState;

    public static class Coordinates{
        private int x;
        private int y;
    }

    public Robot(Coordinates rCoordinates){
        this.currentCoordinates = rCoordinates;
    }

    public void teleport(){

    }

    public void move(){

    }

    public void turnOnPainter(){

    }

    public void turnOffPainter(){

    }
}
