package ru.nsu.yattroman.exceptions;

public class InvalidCommandArgumentException extends RuntimeException {

    public InvalidCommandArgumentException(String message){
        super(message);
    }

}
