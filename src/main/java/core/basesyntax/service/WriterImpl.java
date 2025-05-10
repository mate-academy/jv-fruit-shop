package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    @Override
    public void writeRepo(String reportContent, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(reportContent);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write report to file", e);
        }
    }
}
