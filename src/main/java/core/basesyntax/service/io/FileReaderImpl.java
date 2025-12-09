package core.basesyntax.service.io;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> input(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file from path: " + path, e);
        }
    }
}
