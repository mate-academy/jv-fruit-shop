package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader{
    @Override
    public List<String> read(String file) {
        try {
            return Files.readAllLines(Path.of(file));
        } catch (IOException e) {
            throw new RuntimeException("There was an error reading file.", e);
        }
    }
}
