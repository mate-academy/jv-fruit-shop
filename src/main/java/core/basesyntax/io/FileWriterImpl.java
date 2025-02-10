package core.basesyntax.io;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String content, String filePath) {
        if (filePath == null || content == null) {
            throw new IllegalArgumentException("File path and content cannot be null");
        }

        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while writing to the file: "
                    + filePath, e);
        }
    }
}
