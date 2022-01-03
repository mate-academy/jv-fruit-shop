package core.basesyntax.services.implementation;

import core.basesyntax.services.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriterService {
    private static final String FILE_WRITE_EXCEPTION = "Can't write to file.";

    @Override
    public void write(String report, String fileName) {
        try {
            Files.writeString(Path.of(fileName), report);
        } catch (IOException e) {
            throw new RuntimeException(FILE_WRITE_EXCEPTION + " Exception: " + e);
        }
    }
}
