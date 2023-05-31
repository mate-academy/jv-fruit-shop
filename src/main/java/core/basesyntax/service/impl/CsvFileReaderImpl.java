package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public List<String> readFile(String filePath) {
        File fileName = new File(filePath);
        List<String> fileLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                fileLines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + filePath, e);
        }
        return fileLines;
    }
}
