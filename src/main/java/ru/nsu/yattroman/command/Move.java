package ru.nsu.yattroman.command;

public class Move extends MovementCommand {
     private Direction dir;
     private int stepsCount;

    public enum Direction {
        L, R, U, D
    }

    public Move(Direction dir, int stepsCount) {
        this.dir = dir;
        this.stepsCount = stepsCount;
    }

    public Move(Direction dir) {
        this.dir = dir;
    }

    @Override
    public void execute(){
        System.out.println("Move command! Directiom: " + dir + ". Steps: " + stepsCount);
    }
}