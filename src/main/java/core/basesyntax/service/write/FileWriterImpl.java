package core.basesyntax.service.write;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String filePath, String report) {
        try {
            Files.writeString(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Error writing the file: " + filePath, e);
        }
    }
}
