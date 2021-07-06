package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String report, String file) {
        try {
            Files.writeString(Path.of(file), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + file, e);
        }
    }
}
