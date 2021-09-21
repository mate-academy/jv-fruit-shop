package core.basesyntax.services.implementation;

import core.basesyntax.services.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReaderService {
    private static final String FILE_READ_EXCEPTION = "Can't read from file";

    @Override
    public List<String> read(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(FILE_READ_EXCEPTION + " Exception: " + e);
        }
    }
}
