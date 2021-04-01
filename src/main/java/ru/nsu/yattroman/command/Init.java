package ru.nsu.yattroman.command;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.checker.ArgsChecker;
import ru.nsu.yattroman.environment.Robot;

import java.util.ArrayList;
import java.util.HashMap;

public class Init extends FundamentalCommand {

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers, Robot robot){
        boolean check1 = argsCheckers.get("mapParameters").check(args[1], args[2]);

        if(check1){
            GameMaster.currentMapWidth = Integer.parseInt(args[1]);
            GameMaster.currentMapHeight = Integer.parseInt(args[2]);
            GameMaster.hasMapBeenInitialized = true;

            boolean check2 = argsCheckers.get("coordinates").check(args[3], args[4]);

            if(check2){
                System.out.println("Init command!" + args[1] + " " + args[2] + " " + args[3] + " " + args[4]);
            }
        }
    }

}
