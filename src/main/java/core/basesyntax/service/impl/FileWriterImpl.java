package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultingReport, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.write(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to the file", e);
        }
    }
}
