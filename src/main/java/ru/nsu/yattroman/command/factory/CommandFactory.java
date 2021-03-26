package ru.nsu.yattroman.command.factory;

import ru.nsu.yattroman.command.Command;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.*;

public class CommandFactory {
    private static final String COMMAND_PROPERTY_FILE = "D:\\NSU\\JAVA_NSU_LABS\\Lab2\\src\\main\\resources\\config.properties";
    protected Map<String, Class<? extends Command>> commandClasses = new HashMap<>();
    protected Map<String, Command> commandTypes = new HashMap<>();
    protected Properties classProperties;
    
    private static CommandFactory instance;

    public CommandFactory(){
        try {
            initCommandFactoryFromSysProp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static CommandFactory getCommandFactory() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    private Command newInstance(String commandName, Class<? extends Command>[] parameterTypes, Object[] parameters) {
        Command command = null;

        try {
            Class<? extends Command> commandClass = commandClasses.get(commandName);
            if(commandClass == null){
                throw new RuntimeException("No class registered with name " + commandName);
            }
            Constructor<? extends Command> commandConstr = commandClass.getConstructor(parameterTypes);
            command = commandConstr.newInstance(parameters);
        } catch (Exception e){
            e.printStackTrace();
        }

        return command;
    }
    private Command newInstance(String commandName){
        return newInstance(commandName, new Class[] {}, new Object[] {});
    }

    public Command getInstance(String commandName, Class<? extends Command>[] parameterTypes, Object[] parameters){
        Command command = commandTypes.get(commandName);

        if(command == null){
            command = newInstance(commandName, parameterTypes, parameters);
            commandTypes.put(commandName, command);
        }

        return command;
    }
    public Command getInstance(String commandName) {
        return getInstance(commandName, new Class[] {  }, new Object[] {  });
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
            commandClasses.put(commandName, commandClass);
        }
    }

}
