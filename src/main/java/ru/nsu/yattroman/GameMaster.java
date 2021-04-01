package ru.nsu.yattroman;

import ru.nsu.yattroman.command.CommandHandler;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.environment.Robot;

public class GameMaster {
    private final CommandHandler commandHandler;
    public Robot robot;
    public Map map;

    public static int currentMapWidth;
    public static int currentMapHeight;
    public static boolean hasMapBeenInitialized = false;

    public GameMaster(){
        commandHandler = new CommandHandler();
        robot = null;
        map = null;
//        robot = new Robot(new Robot.Coordinates(0, 0));
    }

    public void playGame(){
        commandHandler.executeNextCommand(this.robot, this.map);
//        map.showMap();
        commandHandler.executeNextCommand(robot, map);
        commandHandler.executeNextCommand(robot, map);
        commandHandler.executeNextCommand(robot, map);
        commandHandler.executeNextCommand(robot, map);
    }

}
