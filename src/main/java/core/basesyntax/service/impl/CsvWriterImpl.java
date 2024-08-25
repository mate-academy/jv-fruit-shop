package core.basesyntax.service.impl;

import core.basesyntax.service.CsvWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterImpl implements CsvWriter {
    @Override
    public void write(String fileName, String string) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(string);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("An exception occurred while writing a file = ["
                    + fileName + "]", e);
        }
    }
}
