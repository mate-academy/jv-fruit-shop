package core.basesyntax.services;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements core.basesyntax.services.FileWriter {
    @Override
    public void write(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}

