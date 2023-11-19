package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriterImpl implements DataWriter {
    @Override
    public void writeData(String data, String toFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFile))) {
            writer.write(data);
            System.out.println("Data successfully written to " + toFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't wrote report to file" + toFile, e);
        }
    }
}
