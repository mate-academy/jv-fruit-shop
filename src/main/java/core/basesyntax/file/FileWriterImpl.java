package core.basesyntax.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String filePath) {
        try {
            Files.write(Path.of(filePath),report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file " + filePath, e);
        }
    }
}
