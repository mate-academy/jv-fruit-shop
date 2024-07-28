package core.basesyntax.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements core.basesyntax.service.FileWriter {
    public void writeToFile(String data, String toFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFile))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + toFile, e);
        }
    }
}
