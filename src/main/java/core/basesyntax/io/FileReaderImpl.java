package core.basesyntax.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String filePath) {

        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path can't be null or empty");
        }

        Path path = Paths.get(filePath);

        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + filePath, e);
        }
    }
}
