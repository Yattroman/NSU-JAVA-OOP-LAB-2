package ru.nsu.yattroman.command;

import ru.nsu.yattroman.checker.ArgsChecker;

import java.util.ArrayList;
import java.util.HashMap;

public class Move extends MovementCommand {

    public enum Direction {
        L, R, U, D
    }

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers){
        System.out.println("Move command!");
    }
}