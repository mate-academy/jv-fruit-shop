package core.basesyntax.service.operations.report.impl;

import core.basesyntax.service.operations.report.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    public void writeDataToFile(String reportContent, String filePath) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            writer.write(reportContent);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write report to file", e);
        }
    }
}
