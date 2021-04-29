package ru.nsu.yattroman.command;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.checker.ArgsChecker;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.environment.Robot;

import java.util.HashMap;

/**
 * Класс команды INIT <width> <height> <x> <y>
 */
public class Init extends FundamentalCommand {

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers, GameMaster gameMaster){
        boolean check1 = argsCheckers.get("mapParameters").check(args[1], args[2]);

        if(check1){
            GameMaster.currentMapWidth = Integer.parseInt(args[1]);
            GameMaster.currentMapHeight = Integer.parseInt(args[2]);
            GameMaster.hasMapBeenInitialized = true;

            boolean check2 = argsCheckers.get("coordinates").check(args[3], args[4]);

            if(check2){
                gameMaster.setMap(new Map(GameMaster.currentMapWidth, GameMaster.currentMapHeight));

                int x = Integer.parseInt(args[3]);
                int y = Integer.parseInt(args[4]);

                gameMaster.getMap().setRobot(new Robot(new Robot.Coordinates(x, y), gameMaster.getMap()));
                gameMaster.getMap().setCell(gameMaster.getMap().getRobot().getCoordinates(), 'R');

            }
        }
    }

}
