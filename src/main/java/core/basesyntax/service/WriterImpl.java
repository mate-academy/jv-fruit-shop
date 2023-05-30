package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriterImpl implements Writer {

    @Override
    public void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.append(content);
        } catch (Exception e) {
            throw new RuntimeException("Can't write to file " + filePath);
        }
    }
}
