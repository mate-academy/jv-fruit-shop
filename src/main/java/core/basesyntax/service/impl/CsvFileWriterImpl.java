package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class CsvFileWriterImpl implements FileWriter {
    @Override
    public void write(String content, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filename))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + filename, e);
        }
    }
}
