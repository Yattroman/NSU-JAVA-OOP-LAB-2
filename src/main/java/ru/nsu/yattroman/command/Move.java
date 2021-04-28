package ru.nsu.yattroman.command;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.checker.ArgsChecker;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.environment.Robot;

import java.util.HashMap;

public class Move extends MovementCommand {

    public enum Direction {
        L, R, U, D
    }

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers, GameMaster gameMaster){
        boolean check1 = argsCheckers.get("direction").check(args[1]);

        if(check1 && GameMaster.hasMapBeenInitialized){
            Robot robot = gameMaster.getMap().getRobot();

            if(robot.getPainterState())
                gameMaster.getMap().setCell(robot.getCoordinates(), '.');
            else
                gameMaster.getMap().setCell(robot.getCoordinates(), '0');

            robot.move(Direction.valueOf(args[1]));

            gameMaster.getMap().setCell(robot.getCoordinates(), 'R');
//            System.out.println(robot.getCoordinates()); CHECK COMMAND
        }

    }
}