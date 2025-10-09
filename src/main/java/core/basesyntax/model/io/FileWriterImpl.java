package core.basesyntax.model.io;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        if (filePath == null || filePath.isBlank()) {
            throw new RuntimeException("File path is null or empty");
        }
        if (data == null) {
            throw new RuntimeException("Data to write is null");
        }

        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Could not write file: " + filePath, e);
        }
    }
}
