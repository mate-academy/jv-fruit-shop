package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultReporting, String fullPath) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fullPath))) {
            writer.write(resultReporting);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file: " + fullPath, e);
        }
    }
}
