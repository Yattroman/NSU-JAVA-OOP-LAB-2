package ru.nsu.yattroman.environment;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.Move;

public class Robot {
    private Coordinates currentCoordinates;
    private boolean painterState;
    private final Map map;

    public static class Coordinates{
        private int x;
        private int y;

        public Coordinates(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Coordinates(Coordinates coordinates){
            this.x = coordinates.x;
            this.y = coordinates.y;
        }

        @Override
        public String toString(){
            return "X coordinates: "+ x + ". Y coordinates: " + y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public Robot(Coordinates rCoordinates, Map map){
        this.currentCoordinates = rCoordinates;
        this.painterState = false;
        this.map = map;
    }

    public Coordinates getCoordinates(){
        return currentCoordinates;
    }

    public boolean canMove(Coordinates coordinates){
        return (coordinates.x >= 0 && coordinates.y >= 0
                && coordinates.x < map.getWidth() && coordinates.y < map.getHeight());
    }

    public void teleport(Coordinates coordinates){
        if(canMove(coordinates)){
            currentCoordinates.x = coordinates.x;
            currentCoordinates.y = coordinates.y;
        }
    }

    public void move(Move.Direction direction){
        Coordinates tempCooridnates = new Coordinates(currentCoordinates);
        switch (direction){
            case L -> tempCooridnates.x = (currentCoordinates.x - 1) % map.getWidth();
            case R -> tempCooridnates.x = (currentCoordinates.x + 1) % map.getWidth();
            case U -> tempCooridnates.y = (currentCoordinates.y + 1) % map.getHeight();
            case D -> tempCooridnates.y = (currentCoordinates.y - 1) % map.getHeight();
        }

        if(canMove(tempCooridnates)){
            currentCoordinates.x = tempCooridnates.x;
            currentCoordinates.y = tempCooridnates.y;
        }
    }

    public void setNewCoordinates(Coordinates newCoordinates){
        currentCoordinates.x = newCoordinates.x;
        currentCoordinates.y = newCoordinates.y;
    }

    public void turnOnPainter(){
        painterState = true;
    }

    public void turnOffPainter(){
        painterState = false;
    }

    public boolean getPainterState(){
        return painterState;
    }
}
