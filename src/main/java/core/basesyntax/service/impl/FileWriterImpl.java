package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String report, String filePath) {
        if (report == null) {
            throw new RuntimeException("Report is null!");
        }
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file by path: " + filePath, e);
        }
    }
}
