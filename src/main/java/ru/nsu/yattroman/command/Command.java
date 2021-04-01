package ru.nsu.yattroman.command;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.checker.ArgsChecker;

import java.util.HashMap;

public abstract class Command {

    public abstract void execute(String[] args, HashMap<String, ArgsChecker> HashMap, GameMaster gameMaster);

}
