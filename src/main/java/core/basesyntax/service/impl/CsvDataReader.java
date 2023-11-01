package core.basesyntax.service.impl;

import core.basesyntax.service.DataReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDataReader implements DataReader {
    private static final String EXCEPTION_MESSAGE = "Can't read file";
    @Override
    public List<String> readFileLines(String pathName) {
        File file = new File(pathName);
        List<String> resultList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String readerString = reader.readLine();
            while (readerString != null) {
                resultList.add(readerString.trim());
                readerString = reader.readLine();
            }
            return resultList;
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE + pathName, e);
        }
    }
}
