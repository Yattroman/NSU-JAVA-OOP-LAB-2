package ru.nsu.yattroman;

public class Main {
    public static void main(String[] args) {
        GameMaster gm = new GameMaster();
        boolean gameStatus;

        do{
            gameStatus = gm.playGame();
        } while (gameStatus);

    }
}
