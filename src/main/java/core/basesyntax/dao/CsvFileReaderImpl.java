package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {

    @Override
    public List<String> read(String filePath) {
        List<String> dataFromFile = new ArrayList<>();
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + filePath + e);
        }
    }
}
