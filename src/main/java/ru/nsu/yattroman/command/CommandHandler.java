package ru.nsu.yattroman.command;

import lombok.EqualsAndHashCode;
import ru.nsu.yattroman.command.checker.ArgsChecker;
import ru.nsu.yattroman.command.checker.CoordinatesChecker;
import ru.nsu.yattroman.command.checker.DirectionChecker;
import ru.nsu.yattroman.command.checker.MapParametersChecker;
import ru.nsu.yattroman.command.factory.CommandFactory;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.environment.Robot;
import ru.nsu.yattroman.textProcessing.FileReader;

import java.util.*;

@EqualsAndHashCode
public class CommandHandler {
    final private CommandFactory commandFactory;
    final private String playFileName = "D:\\NSU\\JAVA_NSU_LABS\\Lab2\\src\\main\\resources\\test.txt";
    final private HashMap<String ,ArgsChecker> argsCheckers = new HashMap<>();

    final FileReader reader;
    String[] commandAndArguments;

    public CommandHandler(){
        commandFactory = new CommandFactory();
        this.reader = new FileReader(playFileName);

        argsCheckers.put(new String("coordinates"), new CoordinatesChecker());
        argsCheckers.put(new String("mapParameters"), new MapParametersChecker());
        argsCheckers.put(new String("direction"), new DirectionChecker());
    }

    public void executeNextCommand(Robot robot, Map map){
        commandAndArguments = reader.getSplitedTextLine();
        Command currentCommand = commandFactory.getInstance(commandAndArguments[0]);
        currentCommand.execute(commandAndArguments, argsCheckers, robot, map);
    }

}