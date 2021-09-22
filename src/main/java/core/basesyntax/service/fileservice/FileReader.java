package core.basesyntax.service.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    public List<String> read(String file) {
        try {
            return Files.readAllLines(Path.of(file));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file");
        }
    }
}

