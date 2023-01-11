package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriterImpl implements DataWriter {
    @Override
    public void writeData(String toFile, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + e);
        }
    }
}
