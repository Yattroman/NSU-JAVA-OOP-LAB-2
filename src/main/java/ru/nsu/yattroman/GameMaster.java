package ru.nsu.yattroman;

import lombok.Getter;
import ru.nsu.yattroman.command.CommandHandler;
import ru.nsu.yattroman.environment.Map;
import ru.nsu.yattroman.view.ConsoleView;

@Getter
public class GameMaster {
    private final CommandHandler commandHandler;
    private Map map;
    private ConsoleView consoleView;

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
        boolean commandExecuted = commandHandler.executeNextCommand(this);
        if(!commandExecuted){
            return false;
        }
        consoleView.showMap(this);

        return true;
    }

}
