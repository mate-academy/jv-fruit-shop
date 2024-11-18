package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(
                new java.io.FileWriter(fileName))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("File: " + fileName + " was not created", e);
        }
    }
}
