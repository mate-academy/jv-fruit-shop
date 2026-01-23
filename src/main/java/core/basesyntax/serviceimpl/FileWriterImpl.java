package core.basesyntax.serviceimpl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String fileName) {
        if (data == null) {
            throw new IllegalArgumentException("Data can't be null");
        }
        if (fileName == null) {
            throw new IllegalArgumentException("FileName can't be null");
        }
        if (fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("FileName can't be empty");
        }

        try {
            Path path = Path.of(fileName);
            Path parent = path.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }
            Files.writeString(path, data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName, e);
        }
    }
}
