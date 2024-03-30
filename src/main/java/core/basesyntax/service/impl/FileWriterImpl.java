package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.util.Map;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(Map<String, Integer> report, String filePath) {
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(filePath)) {
            fileWriter.write(report.toString());
        } catch (Exception e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
    }
}
