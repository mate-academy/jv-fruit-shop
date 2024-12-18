package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(Path filePath) {
        List<String> records;
        try {
            records = Files.readAllLines(filePath);
            return records;
        } catch (IOException e) {
            throw new RuntimeException(String.format("Can't read file: %s", filePath), e);
        }
    }
}
