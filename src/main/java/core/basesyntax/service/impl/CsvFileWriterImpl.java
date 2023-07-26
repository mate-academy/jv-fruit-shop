package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterImpl implements CsvFileWriter {
    public static final String FIRST_LINE = "fruit,quantity" + System.lineSeparator();

    @Override
    public void write(String fileName, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(FIRST_LINE + report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data in file " + fileName, e);
        }
    }
}
