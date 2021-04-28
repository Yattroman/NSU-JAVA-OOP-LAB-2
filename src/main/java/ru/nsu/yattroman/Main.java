package ru.nsu.yattroman;

import ru.nsu.yattroman.command.Command;
import ru.nsu.yattroman.command.Move;
import ru.nsu.yattroman.command.factory.CommandFactory;

public class Main {
    public static void main(String[] args) {
        GameMaster gm = new GameMaster();

        while (gm.playGame()){

        }

//        cf.getInstance("MOVE").execute();
//        cf.getInstance("DRAW").execute();
//        cf.getInstance("WARD").execute();
    }
}
