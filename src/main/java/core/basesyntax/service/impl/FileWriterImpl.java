package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeData(String path, String report) {
        try {
            Files.write(Path.of(path), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cant write to file by path: " + path, e);
        }
    }
}
