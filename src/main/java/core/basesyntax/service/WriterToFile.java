package core.basesyntax.service;

import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {
    public void print(String report, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("No Such File");
        }
    }
}
