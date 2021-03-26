package ru.nsu.yattroman;

import ru.nsu.yattroman.command.Command;
import ru.nsu.yattroman.command.Move;
import ru.nsu.yattroman.command.factory.CommandFactory;

public class Main {
    public static void main(String[] args) {
        Class<? extends Command> cls[] = new Class[] { Move.Direction.class };
        Object[] obj = new Object[] { Move.Direction.L};
        CommandFactory cf = new CommandFactory();

        cf.getInstance("MOVE").execute();
//        cf.getInstance("DRAW").execute();
//        cf.getInstance("WARD").execute();
    }
}
