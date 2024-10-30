package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements FruitFileWriter {
    @Override
    public void write(String report, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while writing to a file: " + filename, e);
        }
    }
}
