package ru.nsu.yattroman.environment;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.Move;

/**
 * Класс робота
 */
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

    /**
     * Проверяет координаты
     * @param coordinates
     * @return
     */
    public boolean canMove(Coordinates coordinates){
        return (coordinates.x >= 0 && coordinates.y >= 0
                && coordinates.x < map.getWidth() && coordinates.y < map.getHeight());
    }

    public void teleport(Coordinates coordinates){
        if(canMove(coordinates)){
            currentCoordinates.x = coordinates.x;
            currentCoordinates.y = coordinates.y;
            GameMaster.logger.trace("Robot has been teleported.");
        }
    }

    public int getCalculatedCoordinate(int currentCoordinate, int addition, int maxparam){
        if(currentCoordinate == 0 && addition == -1) {
            currentCoordinate = maxparam - 1;
        } else {
            currentCoordinate = (currentCoordinate + addition) % maxparam;
        }

        return currentCoordinate;
    }
    /**
     * Метод робота move, меняет координаты робота в соответствии с заданными параметами
     * Координаты меняются, будто бы карта - тороидальное поле
     * @param direction
     */
    public void move(Move.Direction direction){
        Coordinates tempCooridnates = new Coordinates(currentCoordinates);
        switch (direction){
            case R -> tempCooridnates.x = getCalculatedCoordinate(currentCoordinates.x , 1, map.getWidth());
            case L -> tempCooridnates.x = getCalculatedCoordinate(currentCoordinates.x , -1, map.getWidth());
            case D -> tempCooridnates.y = getCalculatedCoordinate(currentCoordinates.y , 1, map.getHeight());
            case U -> tempCooridnates.y = getCalculatedCoordinate(currentCoordinates.y , -1, map.getHeight());
        }

        if(canMove(tempCooridnates)){
            currentCoordinates.x = tempCooridnates.x;
            currentCoordinates.y = tempCooridnates.y;
            GameMaster.logger.trace("Robot has been moved.");
        }
    }

    public void setNewCoordinates(Coordinates newCoordinates){
        currentCoordinates.x = newCoordinates.x;
        currentCoordinates.y = newCoordinates.y;
    }

    public void turnOnPainter(){
        GameMaster.logger.trace("Painter turned on.");
        painterState = true;
    }

    public void turnOffPainter(){
        GameMaster.logger.trace("Painter turned off.");
        painterState = false;
    }

    public boolean getPainterState(){
        return painterState;
    }
}
