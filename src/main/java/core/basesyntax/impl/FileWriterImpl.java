package core.basesyntax.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeReport(String data, String path) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(path))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write report to file: " + path, e);
        }

    }

}
