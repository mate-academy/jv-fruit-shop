package core.basesyntax.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String fileName) {
        try {
            Files.writeString(Paths.get(fileName), report);
        } catch (IOException e) {
            throw new RuntimeException("Error writing file " + fileName, e);
        }
    }
}
