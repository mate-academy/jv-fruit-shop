package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderFromFile {
    private static final String FILE_NAME = "operations.csv";
    private List<String> operations = new ArrayList<>();

    public List<String> readFromFile(String fileName) {
        try {
            operations = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from File" + FILE_NAME);
        }
        return operations;
    }
}
