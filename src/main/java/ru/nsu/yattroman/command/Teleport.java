package ru.nsu.yattroman.command;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.checker.ArgsChecker;
import ru.nsu.yattroman.environment.Robot;

import java.util.ArrayList;
import java.util.HashMap;

public class Teleport extends MovementCommand {

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers, Robot robot){
        boolean check1 = argsCheckers.get("coordinates").check(args[1], args[2]);

        if(check1 && GameMaster.hasMapBeenInitialized)
            System.out.println("Teleport command!" + " " + args[1] + " " + args[2]);
    }
}
