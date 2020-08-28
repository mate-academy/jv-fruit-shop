package core.basesyntax;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FruitFileWriter {
    public void writeFruits(String fruits, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.append(fruits);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file", e);
        }
    }
}
