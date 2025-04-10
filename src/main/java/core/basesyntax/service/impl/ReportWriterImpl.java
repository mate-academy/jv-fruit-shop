package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeIntoFile(String path, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file " + path, e);
        }
    }
}
