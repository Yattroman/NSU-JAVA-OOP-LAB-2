package ru.nsu.yattroman.command;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.checker.ArgsChecker;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.environment.Robot;

import java.util.HashMap;

/**
 * Класс команды MOVE [L|R|U|D] <steps>
 */
public class Move extends MovementCommand {

    public enum Direction {
        L, R, U, D
    }

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers, GameMaster gameMaster){
        boolean check1 = argsCheckers.get("direction").check(args[1]);
        boolean check2 = argsCheckers.get("steps").check(args[2]);

        if(check1 && check2 && GameMaster.hasMapBeenInitialized){
            Robot robot = gameMaster.getMap().getRobot();
            int stepsCount = Integer.parseInt(args[2]);

            for (int i = 0; i < stepsCount; i++) {
                if(robot.getPainterState())
                    gameMaster.getMap().setCell(robot.getCoordinates(), '.');
                else
                    gameMaster.getMap().setCell(robot.getCoordinates(), '0');

                robot.move(Direction.valueOf(args[1]));
            }

            gameMaster.getMap().setCell(robot.getCoordinates(), 'R');
        }

        if (!GameMaster.hasMapBeenInitialized)
            GameMaster.logger.error("Map hasn't been initialized");

    }
}