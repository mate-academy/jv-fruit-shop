package core.basesyntax.serviceimpl;

import core.basesyntax.service.CsvReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvReaderImpl implements CsvReader {
    @Override
    public List<String> readFromFile(String filePath) {
        File file = new File(filePath);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file: " + file.getName(), e);
        }
    }
}
