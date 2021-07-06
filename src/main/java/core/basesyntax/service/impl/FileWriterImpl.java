package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.append(content);
        } catch (Exception e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
    }
}
