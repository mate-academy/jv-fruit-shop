package myfirstproject.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import myfirstproject.service.ReadFile;

public class ReadFileImpl implements ReadFile {
    private static final String COMMA = ",";

    @Override
    public void readFile(List<String[]> temporalData, String path) {
        try (BufferedReader objReader = new BufferedReader(new FileReader(path))) {
            String strCurrentLine;
            while ((strCurrentLine = objReader.readLine()) != null) {
                temporalData.add(strCurrentLine.split(COMMA));
            }
        } catch (IOException e) {
            System.out.println("Can't read from file. " + path + e);
        }
    }
}
