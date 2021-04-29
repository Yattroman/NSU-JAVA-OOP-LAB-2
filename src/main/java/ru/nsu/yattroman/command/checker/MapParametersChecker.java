package ru.nsu.yattroman.command.checker;

import ru.nsu.yattroman.GameMaster;

/**
 * Класс-наследник "проверяльщика аргументов", проверяет параметры карты на валидность
 */
public class MapParametersChecker extends ArgsChecker{
    @Override
    public boolean check(String... args){
        
        int width = Integer.parseInt(args[0]);
        int heigth = Integer.parseInt(args[1]);

        if (width < 0 || heigth < 0){
            GameMaster.logger.error("Invalid map parameters!");
            return false;
        }

        return true;
    }
}
