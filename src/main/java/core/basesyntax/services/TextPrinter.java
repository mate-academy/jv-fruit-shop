package core.basesyntax.services;

import java.io.FileWriter;
import java.io.IOException;

public class TextPrinter {

    public void print(String report, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
