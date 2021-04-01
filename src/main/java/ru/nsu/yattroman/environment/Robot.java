package ru.nsu.yattroman.environment;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.Move;

public class Robot {
    private Coordinates currentCoordinates;
    private boolean painterState;

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
    }

    public Robot(Coordinates rCoordinates){
        this.currentCoordinates = rCoordinates;
    }

    public Coordinates getCoordinates(){
        return currentCoordinates;
    }

    public boolean canMove(Coordinates coordinates){
        return (coordinates.x >= 0 && coordinates.y >= 0 && coordinates.x < GameMaster.currentMapWidth && coordinates.y < GameMaster.currentMapHeight);
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
            case L -> tempCooridnates.x = currentCoordinates.x - 1;
            case R -> tempCooridnates.x = currentCoordinates.x + 1;
            case U -> tempCooridnates.y = currentCoordinates.y + 1;
            case D -> tempCooridnates.y = currentCoordinates.y - 1;
        }

        if(canMove(tempCooridnates)){
            currentCoordinates.x = tempCooridnates.x;
            currentCoordinates.y = tempCooridnates.y;
        }
    }

    public void turnOnPainter(){

    }

    public void turnOffPainter(){

    }
}
