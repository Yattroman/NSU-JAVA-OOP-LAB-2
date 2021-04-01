package ru.nsu.yattroman;

import ru.nsu.yattroman.command.CommandHandler;

public class GameMaster {
    private CommandHandler commandHandler;
    public static int currentMapWidth;
    public static int currentMaphHeight;
    public static boolean hasMapBeenInitialized = false;

    public GameMaster(){
        commandHandler = new CommandHandler();
    }

    public void playGame(){
        commandHandler.executeNextCommand();
        commandHandler.executeNextCommand();
    }

}
