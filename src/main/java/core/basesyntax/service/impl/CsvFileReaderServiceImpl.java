package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {

    @Override
    public List<String> readFormFile(String filePath) {
        File readFromFile = new File(filePath);
        List<String> linesFromFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(readFromFile))) {
            String newLine = bufferedReader.readLine();
            while (newLine != null) {
                linesFromFile.add(newLine);
                newLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file:" + filePath, e);
        }
        return linesFromFile;
    }
}
