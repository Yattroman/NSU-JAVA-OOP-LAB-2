package ru.nsu.yattroman.exceptions;

public class InvalidCommandArgException extends RuntimeException {
    public InvalidCommandArgException(String errorMessage) {
        super(errorMessage);
    }
}
