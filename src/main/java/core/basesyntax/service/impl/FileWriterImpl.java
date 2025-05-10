package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.util.Map;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(Map<String, Integer> report, String filePath) {
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(filePath)) {
            fileWriter.write("fruit, quantity\n");
            for (Map.Entry<String, Integer> entry : report.entrySet()) {
                fileWriter.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
    }
}
