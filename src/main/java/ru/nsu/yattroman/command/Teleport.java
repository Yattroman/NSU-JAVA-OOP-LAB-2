package ru.nsu.yattroman.command;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.checker.ArgsChecker;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.environment.Robot;
import ru.nsu.yattroman.exceptions.InvalidCommandArgException;
import ru.nsu.yattroman.exceptions.MapHasntBeenInitializedException;

import java.util.HashMap;

/**
 * Класс команды TELEPORT
 */
public class Teleport extends MovementCommand {

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers, GameMaster gameMaster){
        boolean check1 = argsCheckers.get("coordinates").check(args[1], args[2]);

        if(!check1) {
            throw new InvalidCommandArgException("-> Teleport command arguments are invalid. Rewrite arguments.");
        }

        if(!GameMaster.hasMapBeenInitialized) {
            GameMaster.logger.error("Map hasn't been initialized");
            throw new MapHasntBeenInitializedException();
        }

        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        Robot robot = gameMaster.getMap().getRobot();
        gameMaster.getMap().setCell(robot.getCoordinates(), '0');

        gameMaster.getMap().getRobot().teleport(new Robot.Coordinates(x, y));

        gameMaster.getMap().setCell(robot.getCoordinates(), 'R');
    }
}
