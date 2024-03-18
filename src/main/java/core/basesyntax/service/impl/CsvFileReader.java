package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileReader implements FileReader {
    private static final int MIN_NUMBER_OF_ROWS = 2;
    private static final int NUMBER_OF_TITLE_ROWS = 1;

    @Override
    public List<String> read(String filePath) {
        if (filePath == null) {
            throw new RuntimeException("Error: The file path is null!");
        }
        try {
            Path path = Paths.get(filePath);
            if (Files.lines(path).count() > MIN_NUMBER_OF_ROWS) {
                return Files.lines(path).skip(NUMBER_OF_TITLE_ROWS)
                        .toList();
            } else {
                throw new RuntimeException("The file is too short or empty");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read data from file");
        }
    }
}
