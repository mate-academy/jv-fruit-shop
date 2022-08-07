package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String pathToFile) {
        List<String> lines;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't reaf from file: " + pathToFile, e);
        }
        return lines;
    }
}
