package myfirstproject.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import myfirstproject.db.TemporalListOfOperations;
import myfirstproject.service.ReadFile;

public class ReadFileImpl implements ReadFile {
    private static final String COMMA = ",";

    @Override
    public void readFile(String path) {
        try (BufferedReader objReader = new BufferedReader(new FileReader(path))) {
            String strCurrentLine;
            while ((strCurrentLine = objReader.readLine()) != null) {
                TemporalListOfOperations.temporalData.add(strCurrentLine.split(COMMA));
            }
        } catch (IOException e) {
            System.out.println("Can't read from file. " + e);
        }
    }
}
