package ru.nsu.yattroman.command;

import ru.nsu.yattroman.checker.ArgsChecker;

import java.util.ArrayList;
import java.util.HashMap;

public class Draw extends DrawSkillCommand {

    @Override
    public void execute(String[] args, HashMap<String ,ArgsChecker> argsCheckers){
        System.out.println("Draw command!");
    }

}
