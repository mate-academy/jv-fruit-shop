package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String s) {
        try {
            return Files.readAllLines(Path.of(s));
        } catch (IOException e) {
            throw new RuntimeException("Cant read File:" + s, e);
        }
    }
}
