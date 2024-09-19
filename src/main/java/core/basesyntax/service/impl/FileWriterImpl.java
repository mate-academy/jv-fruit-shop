package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String text, String filePath) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            writer.write(text);
        } catch (IOException ex) {
            throw new RuntimeException("IOException has happened in the file: " + filePath, ex);
        }
    }
}
