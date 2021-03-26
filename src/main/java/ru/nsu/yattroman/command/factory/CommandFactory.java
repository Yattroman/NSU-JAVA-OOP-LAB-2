package ru.nsu.yattroman.command.factory;

import ru.nsu.yattroman.command.Command;

import java.io.FileInputStream;
import java.util.*;

public class CommandFactory {
    private static final String COMMAND_PROPERTY_FILE = "D:\\NSU\\JAVA_NSU_LABS\\Lab2\\src\\main\\resources\\config.properties";
    protected Map<String, Class<? extends Command>> commandTypes = new HashMap<>();

    static CommandFactory instance;
    protected Properties classProperties;

    public static CommandFactory getCommandFactory() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public void initCommandFactoryFromSysProp() throws Exception{

        classProperties = new Properties();
        var fileIS = new FileInputStream(COMMAND_PROPERTY_FILE);
        classProperties.load(fileIS);
        fileIS.close();

        var iter = classProperties.entrySet().iterator();

        while (iter.hasNext()){
            Map.Entry mapEntry = (Map.Entry) iter.next();
            String commandName = (String) mapEntry.getKey();
            String commandClassName = (String) mapEntry.getValue();
            Class commandClass = Class.forName(commandClassName);
            commandTypes.put(commandName, commandClass);
        }
    }

}
