package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.DataReader;

public class CsvDataReader implements DataReader {
    @Override
    public List<String> readFileLines(String pathName) {
        File file = new File(pathName);
        List<String> resultList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String readerString = reader.readLine();
            while (readerString != null) {
                resultList.add(readerString);
                readerString = reader.readLine();
            }
            return resultList;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + pathName, e);
        }
    }
}
