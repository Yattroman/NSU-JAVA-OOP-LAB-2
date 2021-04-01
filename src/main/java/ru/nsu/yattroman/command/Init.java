package ru.nsu.yattroman.command;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.checker.ArgsChecker;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.environment.Robot;

import java.util.HashMap;

public class Init extends FundamentalCommand {

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers, Robot robot, Map map){
        boolean check1 = argsCheckers.get("mapParameters").check(args[1], args[2]);

        if(check1){
            GameMaster.currentMapWidth = Integer.parseInt(args[1]);
            GameMaster.currentMapHeight = Integer.parseInt(args[2]);
            GameMaster.hasMapBeenInitialized = true;

            boolean check2 = argsCheckers.get("coordinates").check(args[3], args[4]);

            if(check2){
                map = new Map(GameMaster.currentMapWidth, GameMaster.currentMapHeight);

                int x = Integer.parseInt(args[3]);
                int y = Integer.parseInt(args[4]);

                robot = new Robot(new Robot.Coordinates(x, y));

//                System.out.println(robot.getCoordinates()); CHECK COMMAND
//                System.out.println("Height: " + GameMaster.currentMapHeight + ". Width: " + GameMaster.currentMapWidth); CHECK COMMAND
            }
        }
    }

}
