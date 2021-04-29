package ru.nsu.yattroman;

import org.apache.logging.log4j.Logger;

public class Main {

    public static void main(String[] args) {
        GameMaster gm = new GameMaster();
        boolean gameStatus;

        do{
            gameStatus = gm.playGame();
        } while (gameStatus);

    }
}
