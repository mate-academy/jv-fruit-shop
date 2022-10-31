package core.basesyntax.services.impl;

import core.basesyntax.services.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeDate(String path, String report) {
        try {
            Files.write(Path.of(path), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cant write to file");
        }
    }
}
