package core.basesyntax;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CsvFileWriter extends FileDataWriter {
    @Override
    public void write(String filePath, String data) {
        if (filePath == null || filePath.isEmpty()) {
            throw new RuntimeException("Failed to write data to a file. Path is empty");
        }

        Path path = Paths.get(filePath);
        Path parentDir = path.getParent();

        if (parentDir != null && !Files.exists(parentDir)) {
            try {
                Files.createDirectories(parentDir);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create directory " + parentDir, e);
            }
        }

        try {
            Files.writeString(path, data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write the file " + path, e);
        }
    }
}
