package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterImpl implements FileWriter {
    private static final String HEADER = "fruit,quantity";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String SEPARATOR = ",";

    @Override
    public void createReportFile(Map<String, Long> balance, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(filePath))) {
            bufferedWriter.write(HEADER);
            bufferedWriter.write(NEW_LINE);
            for (Map.Entry<String, Long> entry: balance.entrySet()) {
                bufferedWriter.write(entry.getKey());
                bufferedWriter.write(SEPARATOR);
                bufferedWriter.write(entry.getValue().toString());
                bufferedWriter.write(NEW_LINE);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + e);
        }
    }
}
