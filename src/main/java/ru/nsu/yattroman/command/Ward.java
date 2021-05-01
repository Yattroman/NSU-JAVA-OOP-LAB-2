package ru.nsu.yattroman.command;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.checker.ArgsChecker;
import ru.nsu.yattroman.exceptions.MapHasntBeenInitializedException;

import java.util.HashMap;

/**
 * Класс команды WARD
 */
public class Ward extends DrawSkillCommand{

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers, GameMaster gameMaster){

        if(!GameMaster.hasMapBeenInitialized) {
            GameMaster.logger.error("Map hasn't been initialized");
            throw new MapHasntBeenInitializedException();
        }

        gameMaster.getMap().getRobot().turnOffPainter();
    }

}
