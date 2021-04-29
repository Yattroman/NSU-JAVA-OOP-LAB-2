package ru.nsu.yattroman.command;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.checker.ArgsChecker;

import java.util.HashMap;

/**
 * Абстрактный класс Command, родительский для всех исполняемых команд
 */
public abstract class Command {

    /**
     * Абстрактный метод для исполнения команд, принимает подстроки как аргументы, HashMap checker'ов, объект класса GameMaster
     * @param args
     * @param HashMap
     * @param gameMaster
     */
    public abstract void execute(String[] args, HashMap<String, ArgsChecker> HashMap, GameMaster gameMaster);

}
