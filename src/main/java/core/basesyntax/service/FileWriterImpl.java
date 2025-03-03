package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String report, Path filePath) throws IOException {
        try {
            Files.writeString(filePath, report);
        } catch (IOException e) {
            throw new IOException("Error writing to file at path: " + filePath, e);
        }
    }
}
