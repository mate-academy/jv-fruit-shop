package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultingReport, String fileName) {
        String fullPath = String.valueOf(
                Paths.get("src", "main", "java", "resources", fileName));
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fullPath))) {
            writer.write(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to the file", e);
        }
    }
}

