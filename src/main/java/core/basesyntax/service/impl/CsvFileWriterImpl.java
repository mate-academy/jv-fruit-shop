package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String COMMA = ",";
    private static final String REPORT_FIRST_LINE = "fruit,quantity";
    @Override
    public void writeReport(String filePath, Map<Fruit, Integer> storage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(REPORT_FIRST_LINE + System.lineSeparator());
            for (Map.Entry<Fruit, Integer> entry: storage.entrySet()) {
                writer.write((entry.getKey().getName() + COMMA + entry.getValue()
                        + System.lineSeparator()));
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Problem to write new file ", e);
        }
    }
}
