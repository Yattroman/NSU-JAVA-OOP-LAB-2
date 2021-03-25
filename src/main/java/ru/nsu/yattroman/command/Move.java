package ru.nsu.yattroman.command;

public class Move extends MovementCommand {
    Direction dir;

    public enum Direction {
        L, R, U, D
    }

    public Move(Direction dir) {
        this.dir = dir;
    }

    @Override
    public void execute(){
        System.out.println("Move command!");
    }
}