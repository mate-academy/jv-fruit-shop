package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    private final String filePath;

    public FileWriterImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String text) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            writer.write(text);
        } catch (IOException ex) {
            throw new RuntimeException("IOException has happened in the file: " + filePath, ex);
        }
    }
}
