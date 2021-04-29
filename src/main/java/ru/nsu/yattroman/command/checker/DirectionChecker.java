package ru.nsu.yattroman.command.checker;

import ru.nsu.yattroman.GameMaster;

/**
 * Класс-наследник "проверяльщика аргументов", проверяет направления движения на валидность
 */
public class DirectionChecker extends ArgsChecker{
    @Override
    public boolean check(String... args){

        if(args[0].equals("L") ||  args[0].equals("R") || args[0].equals("U") || args[0].equals("D")){
            return true;
        }
        GameMaster.logger.error("Invalid direction!");

        return false;
    }
}
