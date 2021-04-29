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
        gameMaster.getMap().getRobot().turnOnPainter();
    }

}
