package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileReader implements FileReader {
    @Override
    public List<String> readData(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException ex) {
            throw new RuntimeException(
                    String.format("Can`t read data from the file %s", filePath),
                    ex
            );
        }
    }
}
