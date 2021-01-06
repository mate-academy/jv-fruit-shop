package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterImpl implements CsvFileWriter {
    @Override
    public void createReportFile(Map<String, Long> storageBalance, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Long> entry : storageBalance.entrySet()) {
                bufferedWriter.write(entry.getKey() + ":" + entry.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
