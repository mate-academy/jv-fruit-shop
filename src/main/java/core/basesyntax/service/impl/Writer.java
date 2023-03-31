package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterReport;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer implements FileWriterReport {
    @Override
    public void writeToFile(String data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileName, e);
        }
    }
}
