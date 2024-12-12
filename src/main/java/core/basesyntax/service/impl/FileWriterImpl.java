package core.basesyntax.service.impl;

import core.basesyntax.service.MyFileWriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements MyFileWriter {
    @Override
    public void write(String report, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + filePath, e);
        }
    }
}
