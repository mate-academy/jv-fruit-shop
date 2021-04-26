package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    private static final String TITLE = "fruit, quantity";
    private static final String ERROR_MESSAGE = "Can't write to file in this path";

    @Override
    public void write(String path, String report) {
        try {
            Files.writeString(Path.of(path),
                    TITLE + System.lineSeparator() + report);
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE + " " + path, e);
        }
    }
}
