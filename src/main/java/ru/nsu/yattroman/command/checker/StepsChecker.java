package ru.nsu.yattroman.command.checker;

import ru.nsu.yattroman.GameMaster;

public class StepsChecker extends ArgsChecker{
    @Override
    public boolean check(String... args){

        int steps = Integer.parseInt(args[0]);

        if(steps < 0){
            GameMaster.logger.error("Invalid steps count!");
            return false;
        }

        return true;
    }
}
