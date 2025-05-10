package core.basesyntax.file.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        try {
            Files.writeString(Paths.get(filePath), data);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file: " + filePath, e);
        }
    }
}
