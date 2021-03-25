package ru.nsu.yattroman.command.factory;

import ru.nsu.yattroman.command.Command;

import java.util.*;

public class CommandFactory {
    private static final String COMMAND_PROPERTY_FILE = "ru.nsu.yattroman.command";
    protected Map<String, Class<? extends Command>> commandTypes = new HashMap<>();
    protected Properties keysToClassNames;

}
