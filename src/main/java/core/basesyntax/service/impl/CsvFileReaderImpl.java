package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    private static final String SEPARATOR = ",";
    private final List<String[]> recordsFromFile = new ArrayList<>();

    @Override
    public List<String[]> readDataFromFile(Path path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(SEPARATOR);
                recordsFromFile.add(arr);
            }
        } catch (IOException e) {
            System.out.println("There's something gone wrong " + e);
        }
        return recordsFromFile;
    }
}
