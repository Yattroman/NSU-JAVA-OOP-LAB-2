package ru.nsu.yattroman.command;

import ru.nsu.yattroman.command.checker.ArgsChecker;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.environment.Robot;

import java.util.HashMap;

public abstract class Command {

    public abstract void execute(String[] args, HashMap<String, ArgsChecker> HashMap, Robot robot, Map map);

}
