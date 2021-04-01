package ru.nsu.yattroman.command;

import ru.nsu.yattroman.checker.ArgsChecker;
import ru.nsu.yattroman.environment.Robot;

import java.util.ArrayList;
import java.util.HashMap;

public class Ward extends DrawSkillCommand{

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers, Robot robot){
        System.out.println("Ward command!");
    }

}
