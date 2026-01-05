package core.basesyntax.serviceimpl;

import core.basesyntax.service.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String path) {
        if (path == null) {
            throw new RuntimeException("Path can`t be null!");
        }
        try {
            return Files.readAllLines(Path.of(path));
        } catch (Exception e) {
            throw new RuntimeException("Cannot read file: " + path, e);
        }
    }
}
