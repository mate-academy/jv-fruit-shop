package core.basesyntax.service.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterForCsvImpl implements FileWriter {
    private static final String WRITE_TO_FILE_EXCEPTION = "Can't write to file: ";

    @Override
    public void write(String content, String toFile) {
        try {
            Files.write(Path.of(toFile), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(WRITE_TO_FILE_EXCEPTION + toFile, e);
        }
    }
}
