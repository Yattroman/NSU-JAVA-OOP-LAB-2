package ru.nsu.yattroman.command;

import lombok.EqualsAndHashCode;
import ru.nsu.yattroman.checker.ArgsChecker;
import ru.nsu.yattroman.checker.CoordinatesChecker;
import ru.nsu.yattroman.checker.MapParametersChecker;
import ru.nsu.yattroman.command.factory.CommandFactory;
import ru.nsu.yattroman.textProcessing.FileReader;

import java.util.*;

@EqualsAndHashCode
public class CommandHandler {
    CommandFactory commandFactory;
    String playFileName = "D:\\NSU\\JAVA_NSU_LABS\\Lab2\\src\\main\\resources\\test.txt";
    HashMap<String ,ArgsChecker> argsCheckers = new HashMap<>();

    FileReader reader;
    String[] commandAndArguments;

    public CommandHandler(){
        commandFactory = new CommandFactory();
        this.reader = new FileReader(playFileName);

        argsCheckers.put(new String("coordinates"), new CoordinatesChecker());
        argsCheckers.put(new String("mapParameters"), new MapParametersChecker());
    }

    public void executeNextCommand(){
        commandAndArguments = reader.getSplitedTextLine();
        Command currentCommand = commandFactory.getInstance(commandAndArguments[0]);
        currentCommand.execute(commandAndArguments, argsCheckers);
    }

}
