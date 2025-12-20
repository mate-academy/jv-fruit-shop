package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements Writer {
    @Override
    public void write(String report, String fileName) {
        if (report == null || report.isEmpty()) {
            throw new IllegalArgumentException(
                    "Report cannot be null or empty");
        }
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException(
                    "File name cannot be null or empty");
        }
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Can't write report into file: " + fileName, e);
        }
    }
}
