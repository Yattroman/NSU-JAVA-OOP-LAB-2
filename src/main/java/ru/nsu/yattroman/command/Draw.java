package ru.nsu.yattroman.command;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.checker.ArgsChecker;

import java.util.HashMap;

/**
 * Класс команды DRAW
 */
public class Draw extends DrawSkillCommand {

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers, GameMaster gameMaster){
        if (GameMaster.hasMapBeenInitialized)
            gameMaster.getMap().getRobot().turnOnPainter();
        else
            GameMaster.logger.error("Map hasn't been initialized");

    }

}
