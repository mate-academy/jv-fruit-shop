package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriterCsvImpl implements FileWriter {
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    @Override
    public void writeToFile() {
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new java.io.FileWriter(REPORT_FILE_NAME, true))) {
            for (Map.Entry<String, Integer> entry: Storage.STORAGE.entrySet()) {
                bufferedWriter.write(entry.getKey() + "," + entry.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + REPORT_FILE_NAME);
        }
    }
}
