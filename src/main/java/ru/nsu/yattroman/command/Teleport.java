package ru.nsu.yattroman.command;

public class Teleport extends MovementCommand {
    private int x;
    private int y;

    public Teleport(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute(){
        System.out.println("Teleport command!");
    }
}
