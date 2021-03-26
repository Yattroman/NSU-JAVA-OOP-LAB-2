package ru.nsu.yattroman;

import ru.nsu.yattroman.command.factory.CommandFactory;

public class Main {
    public static void main(String[] args) {
        CommandFactory cf = new CommandFactory();

        try {
            cf.initCommandFactoryFromSysProp();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
