package ru.nsu.yattroman.exceptions;

public class MapHasntBeenInitializedException extends RuntimeException{
    public MapHasntBeenInitializedException() {
        super("-> Map hasn't been initialized yet.");
    }
}
