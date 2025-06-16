package core.basesyntax.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String resultingReport, String filePath) {

        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path can't be null or empty");
        }

        Path path = Paths.get(filePath);

        try {
            Files.writeString(path, resultingReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + filePath, e);
        }
    }
}
