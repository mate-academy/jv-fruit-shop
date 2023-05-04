package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderCsvImpl implements FileReader{
    private static final String FILE_NAME = "database.csv";

    @Override
    public List<String> read() {
        List<String> dataBase;
        try {
            dataBase = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("File not found" + FILE_NAME);
        }
        return dataBase;
    }
}
