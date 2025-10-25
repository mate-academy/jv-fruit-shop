package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String fileName, String data) {
        if (data == null || fileName == null) {
            throw new IllegalArgumentException("Data and file name cannot be null");
        }

        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write data to file: " + fileName, e);
        }
    }
}
