package core.basesyntax.service;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String pathToFile, String report) {
        try {
            Files.writeString(Path.of(pathToFile), report);
        } catch (Exception e) {
            throw new RuntimeException("Can't write to the file: " + e);
        }
    }
}
