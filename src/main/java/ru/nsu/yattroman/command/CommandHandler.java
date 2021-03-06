package ru.nsu.yattroman.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.command.checker.*;
import ru.nsu.yattroman.command.factory.CommandFactory;
import ru.nsu.yattroman.exceptions.InvalidCommandArgException;
import ru.nsu.yattroman.exceptions.MapHasntBeenInitializedException;
import ru.nsu.yattroman.textProcessing.FileReader;

import java.util.*;

/**
 * Класс обработчика команд
 * Содержит в себе источник последовательности команд (пользовательская программа), HashMap checker'ов, фабрику команд
 */
@Getter
@EqualsAndHashCode
public class CommandHandler {
    final private CommandFactory commandFactory;
    final private String playFileName = "D:\\NSU\\JAVA_NSU_LABS\\Lab2\\src\\main\\resources\\test.txt";
    final private HashMap<String, ArgsChecker> argsCheckers = new HashMap<>();

    final FileReader reader;
    String[] commandAndArguments;

    public CommandHandler(){
        commandFactory = new CommandFactory();
        this.reader = new FileReader(playFileName);

        argsCheckers.put(new String("coordinates"), new CoordinatesChecker());
        argsCheckers.put(new String("mapParameters"), new MapParametersChecker());
        argsCheckers.put(new String("direction"), new DirectionChecker());
        argsCheckers.put(new String("steps"), new StepsChecker());
    }

    /**
     * Исполненяет следующую команду
     * Считывает строку с файла, затем получает объект команды по имени команд, используя фабрику, потом исполянет эту команду
     * @param gameMaster
     * @return
     */
    public boolean executeNextCommand(GameMaster gameMaster){
        commandAndArguments = reader.getSplitedTextLine();
        if(commandAndArguments == null)
            return false;
        Command currentCommand = commandFactory.getInstance(commandAndArguments[0]);
        try{
            currentCommand.execute(commandAndArguments, argsCheckers, gameMaster);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

}
