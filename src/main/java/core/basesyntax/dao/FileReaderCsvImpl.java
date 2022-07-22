package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderCsvImpl implements FileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        Path filePath = Paths.get(fileName);
        List<String> lines;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName, e);
        }
        return lines;
    }
}
