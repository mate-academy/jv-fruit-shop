package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String report, String fileName) {
        try {
            Files.writeString(Path.of(fileName), report);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write to file " + fileName, e);
        }
    }
}
