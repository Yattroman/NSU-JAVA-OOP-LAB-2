package ru.nsu.yattroman.command.checker;

public class MapParametersChecker extends ArgsChecker{
    @Override
    public boolean check(String... args){
        
        int width = Integer.parseInt(args[0]);
        int heigth = Integer.parseInt(args[1]);

        if (width < 0 || heigth < 0){
            return false;
        }

        return true;
    }
}
