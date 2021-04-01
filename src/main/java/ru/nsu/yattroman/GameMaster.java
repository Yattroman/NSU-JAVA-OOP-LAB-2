package ru.nsu.yattroman;

import ru.nsu.yattroman.command.CommandHandler;
import ru.nsu.yattroman.environment.Robot;

public class GameMaster {
    private CommandHandler commandHandler;
    private Robot robot;
    public static int currentMapWidth;
    public static int currentMapHeight;
    public static boolean hasMapBeenInitialized = false;

    public GameMaster(){
        commandHandler = new CommandHandler();
    }

    public void playGame(){
        commandHandler.executeNextCommand(robot);
        commandHandler.executeNextCommand(robot);
    }

}
