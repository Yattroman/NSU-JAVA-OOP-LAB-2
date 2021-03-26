package ru.nsu.yattroman;

import ru.nsu.yattroman.command.factory.CommandFactory;

public class Main {
    public static void main(String[] args) {
        CommandFactory cf = new CommandFactory();

        cf.getInstance("WARD").execute();
    }
}
