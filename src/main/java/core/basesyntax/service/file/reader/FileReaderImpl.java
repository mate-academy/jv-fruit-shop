package core.basesyntax.service.file.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("File can't be null." + filePath);
        }

        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File does not exist: " + filePath);
        }

        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + filePath, e);
        }
    }
}
