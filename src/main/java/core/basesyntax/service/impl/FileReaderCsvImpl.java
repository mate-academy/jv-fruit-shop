package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderCsvImpl implements FileReader {
    private static final String DATA_BASE_FILE_NAME = "src/main/resources/database.csv";

    @Override
    public List<String> readFromFile() {
        List<String> dataBase;
        try {
            dataBase = Files.readAllLines(Path.of(DATA_BASE_FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("File not found - " + DATA_BASE_FILE_NAME);
        }
        return dataBase;
    }
}
