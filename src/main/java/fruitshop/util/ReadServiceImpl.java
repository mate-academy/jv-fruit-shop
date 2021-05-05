package fruitshop.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadServiceImpl implements ReadService {
    @Override
    public List<String> readFromFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException exception) {
            throw new RuntimeException("Can't read the file " + filePath, exception);
        }
    }
}
