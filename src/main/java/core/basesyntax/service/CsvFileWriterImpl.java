package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String SPLITTER = ",";

    @Override
    public void write(String pathToFile, Map<String, Integer> report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile))) {
            bufferedWriter.write(FRUIT + SPLITTER + QUANTITY + System.lineSeparator());
            for (Map.Entry<String, Integer> entry : report.entrySet()) {
                bufferedWriter.write(entry.getKey() + SPLITTER
                        + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("can't write into file " + pathToFile, e);
        }

    }
}
