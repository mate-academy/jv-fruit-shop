package core.basesyntax.shop.implementation;

import core.basesyntax.shop.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class DataFileWriter implements FileWriter {
    @Override
    public void writeToReport(String values, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write(values);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }
}
