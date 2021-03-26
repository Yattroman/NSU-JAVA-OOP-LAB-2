package ru.nsu.yattroman.command;

public class Move extends MovementCommand {

    public enum Direction {
        L, R, U, D
    }

    @Override
    public void execute(){
        System.out.println("Move command!");
    }
}