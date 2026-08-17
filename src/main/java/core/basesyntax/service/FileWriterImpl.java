package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String filePath) {
        if (report == null || filePath == null) {
            throw new IllegalArgumentException(
                    "Report and file path can't be null"
            );
        }
        try {
            Files.writeString(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException(
                 "Can't write report to file: " + filePath,
                 e);
        }
    }
}
