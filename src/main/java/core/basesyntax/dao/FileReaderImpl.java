package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String filepath) {
        try {
            return Files.readAllLines(Paths.get(filepath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filepath);
        }
    }
}
