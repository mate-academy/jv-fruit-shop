package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.writeString(path, report);
        } catch (IOException e) {
            throw new RuntimeException("Can not write file: " + filePath, e);
        }
    }
}
