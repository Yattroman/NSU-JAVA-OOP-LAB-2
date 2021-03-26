package ru.nsu.yattroman.command;

public class Teleport extends MovementCommand {

    @Override
    public void execute(){
        System.out.println("Teleport command!");
    }
}
