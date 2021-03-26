package ru.nsu.yattroman.fileReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {

    private BufferedReader buffReader;
    private String fileName;

    private FileReader(String fileName){
        try {
            buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        } catch (Exception e){
            System.out.println("Problems with openning file. " + e.getLocalizedMessage() );
        }
    }

    public String readTextLine(){
        String line = "";
        try
        {
            line = buffReader.readLine();
        }
        catch (IOException e)
        {
            System.err.println("Error while reading symbol: " + e.getLocalizedMessage());
        }

        return line;
    }

}
