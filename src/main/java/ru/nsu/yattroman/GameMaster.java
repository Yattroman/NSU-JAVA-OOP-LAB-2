package ru.nsu.yattroman;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nsu.yattroman.command.CommandHandler;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.view.ConsoleView;

@Getter
public class GameMaster {
    private final CommandHandler commandHandler;
    private Map map;
    private ConsoleView consoleView;

    public static final Logger logger = LogManager.getLogger(GameMaster.class);

    public static int currentMapWidth;
    public static int currentMapHeight;

    public static boolean hasMapBeenInitialized = false;

    public Map getMap() {
        return map;
    }
    public void setMap(Map map) {
        this.map = map;
    }

    public GameMaster(){
        commandHandler = new CommandHandler();
        consoleView = new ConsoleView();
        map = null;
    }

    /**
     * Основная функция программы, исполняет комманды из файла, одна за другой.
     * При этом получает статус выполнения команды, и если возникли проблемы с исполнением команды,
     * то завершает false, в ином случае, когда всё хорошо - true.
     **/
    public boolean playGame(){
        logger.trace("Trying to execute command");
        boolean commandExecuted = commandHandler.executeNextCommand(this);
        if(!commandExecuted){
            logger.error("Command haven't been executed.");
            return false;
        }
        logger.trace("Show updated map");
        consoleView.showMap(this);

        return true;
    }

}
