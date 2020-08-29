package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FruitFileWriter {
    public void writeFruits(String fruitsInfo, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.append(fruitsInfo);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file", e);
        }
    }
}
