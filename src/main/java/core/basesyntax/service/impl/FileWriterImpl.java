package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String filePath) {
        try {
            Files.write(Paths.get(filePath), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file" + filePath, e);
        }
    }
}
