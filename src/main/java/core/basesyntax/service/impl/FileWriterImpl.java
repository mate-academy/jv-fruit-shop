package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String fileName) {
        if (report == null || fileName == null) {
            throw new RuntimeException("Report or fileName cannot be null");
        }
        try {
            Files.writeString(Path.of(fileName), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + fileName, e);
        }
    }
}
