package core.basesyntax.dao.impl;

import core.basesyntax.dao.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to file: " + filePath + e);
        }
    }
}
