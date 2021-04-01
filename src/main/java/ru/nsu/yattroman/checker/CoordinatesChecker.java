package ru.nsu.yattroman.checker;

import ru.nsu.yattroman.GameMaster;

public class CoordinatesChecker extends ArgsChecker{
    @Override
    public boolean check(String... args){

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        if(x < 0 || y < 0 || x >= GameMaster.currentMapWidth || y >= GameMaster.currentMapHeight){
            return false; // В идеале должно быть исключение
        }

        return true;
    }
}
