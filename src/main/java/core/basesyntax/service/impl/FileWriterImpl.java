package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String report, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + filePath, e);
        }
    }
}
