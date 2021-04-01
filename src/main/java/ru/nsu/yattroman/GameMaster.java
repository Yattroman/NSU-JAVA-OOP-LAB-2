package ru.nsu.yattroman;

import lombok.Getter;
import ru.nsu.yattroman.command.CommandHandler;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.environment.Robot;

@Getter
public class GameMaster {
    private final CommandHandler commandHandler;
    private Robot robot;
    private Map map;

    public static int currentMapWidth;
    public static int currentMapHeight;
    public static boolean hasMapBeenInitialized = false;

    public Robot getRobot() {
        return robot;
    }

    public Map getMap() {
        return map;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public GameMaster(){
        commandHandler = new CommandHandler();
        robot = null;
        map = null;
    }

    public void playGame(){
        commandHandler.executeNextCommand(this);
        map.showMap();
    }

}
