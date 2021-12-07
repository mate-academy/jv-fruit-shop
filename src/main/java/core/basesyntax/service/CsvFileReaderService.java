package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderService {

    private List<String> operations = new ArrayList<>();

    public List<String> dataReader(String filename) {
        CreateAbsolutePath createAbsolutePath = new CreateAbsolutePath();
        File fileAbsolutePath = createAbsolutePath.createFilePath(filename);

        try {
            operations = Files.readAllLines(fileAbsolutePath.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return operations;
    }
}
