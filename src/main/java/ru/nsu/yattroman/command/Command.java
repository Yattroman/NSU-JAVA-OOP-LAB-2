package ru.nsu.yattroman.command;

import ru.nsu.yattroman.checker.ArgsChecker;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Command {

    public abstract void execute(String[] args, HashMap<String, ArgsChecker> HashMap);

}
