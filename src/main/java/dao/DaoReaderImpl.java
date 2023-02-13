package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DaoReaderImpl implements DaoReader {
    @Override
    public List<String> get(String fileName) {
        try {
            Path path = Path.of(fileName);
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fileName);
        }
    }
}
