package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriterImpl implements DataWriter {
    @Override
    public void write(String report, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileName, e);
        }
    }
}
