package ru.nsu.yattroman.command;

import ru.nsu.yattroman.command.checker.ArgsChecker;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.environment.Robot;

import java.util.HashMap;

public class Draw extends DrawSkillCommand {

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers, Robot robot, Map map){
        robot.turnOnPainter();
        System.out.println(robot.getPainterState());
    }

}
