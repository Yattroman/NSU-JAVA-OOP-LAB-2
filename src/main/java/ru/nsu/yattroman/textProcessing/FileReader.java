package ru.nsu.yattroman.textProcessing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс FileReader, предназанчен для работы с файлами
 */
public class FileReader {

    private BufferedReader buffReader;

    public FileReader(){
        buffReader = null;
    }

    public FileReader(String fileName){
        try {
            buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        } catch (Exception e){
            System.out.println("Problems with openning file. " + e.getLocalizedMessage() );
        }
    }

    public void startReadingFile(String fileName){
        try {
            buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        } catch (Exception e){
            System.out.println("Problems with openning file. " + e.getLocalizedMessage() );
        }
    }

    /**
     * Считывает строку с помощью BufferedReader, если всё прошло успешно, то затем разбивает её на массив подстрок
     * @return
     */
    public String[] getSplitedTextLine(){
        String delimeter = " ";
        String[] splitedTextLine = null;
        String line;
        try
        {
            line = buffReader.readLine();
            if(line == null)
                return null;
            splitedTextLine = line.split(delimeter);
        }
        catch (IOException e)
        {
            System.err.println("Error while reading symbol: " + e.getLocalizedMessage());
        }

        return splitedTextLine;
    }
}
