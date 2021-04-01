package ru.nsu.yattroman.checker;

public class MapParametersChecker extends ArgsChecker{
    @Override
    public boolean check(String[] args){
        int width = Integer.parseInt(args[3]);
        int heigth = Integer.parseInt(args[4]);

        if (width < 0 || heigth < 0){
            return false;
        }

        return true;
    }
}
