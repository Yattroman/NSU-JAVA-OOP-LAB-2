package ru.nsu.yattroman.checker;

import ru.nsu.yattroman.GameMaster;

public class CoordinatesChecker extends ArgsChecker{
    @Override
    public boolean check(String[] args){

        int x = Integer.parseInt(args[3]);
        int y = Integer.parseInt(args[4]);

        if(x < 0 || y < 0 || x >= GameMaster.currentMapWidth || y >= GameMaster.currentMaphHeight){
            return false; // В идеале должно быть исключение
        }

        return true;
    }
}
