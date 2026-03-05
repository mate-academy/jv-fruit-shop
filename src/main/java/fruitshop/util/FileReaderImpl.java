package fruitshop.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (Exception e) {
            throw new RuntimeException("Cannot read file: " + filePath, e);
        }
    }
}