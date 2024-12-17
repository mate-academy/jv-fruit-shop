package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(Path filePath) {
        List<String> records;
        if (filePath.toFile().exists()) {
            try {
                records = Files.readAllLines(filePath);
                return records;
            } catch (IOException e) {
                throw new RuntimeException(String.format("Can't read file: %s", filePath), e);
            }
        }
        throw new RuntimeException(String.format("File: '%s' doesn't exist.", filePath));
    }
}
