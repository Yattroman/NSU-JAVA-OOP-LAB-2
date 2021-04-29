package ru.nsu.yattroman.command.checker;

import ru.nsu.yattroman.GameMaster;

/**
 * Класс-наследник "проверяльщика аргументов", проверяет координаты на валидность
 */
public class CoordinatesChecker extends ArgsChecker{
    @Override
    public boolean check(String... args){

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        if(x < 0 || y < 0 || x >= GameMaster.currentMapWidth || y >= GameMaster.currentMapHeight){
            GameMaster.logger.error("Invalid coordinates");
            return false;
        }

        return true;
    }
}
