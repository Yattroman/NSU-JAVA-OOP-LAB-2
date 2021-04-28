package ru.nsu.yattroman.view;

import ru.nsu.yattroman.GameMaster;
import ru.nsu.yattroman.environment.Robot;

public class ConsoleView {
    public void showMap(GameMaster gameMaster){
        for (int i = 0; i < gameMaster.getMap().getWidth(); ++i) {
            for (int j = 0; j < gameMaster.getMap().getHeight(); ++j) {
                System.out.print( gameMaster.getMap().getMapHolder()[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
