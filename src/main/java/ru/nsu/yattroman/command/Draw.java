package ru.nsu.yattroman.command;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.checker.ArgsChecker;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.environment.Robot;

import java.util.HashMap;

public class Draw extends DrawSkillCommand {

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers, GameMaster gameMaster){
        gameMaster.getMap().getRobot().turnOnPainter();
    }

}
