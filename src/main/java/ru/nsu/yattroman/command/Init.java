package ru.nsu.yattroman.command;

public class Init extends FundamentalCommand {
    private int width;
    private int height;

    private int x;
    private int y;

    public Init(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute(){
        System.out.println("Init command!");
    }
}
