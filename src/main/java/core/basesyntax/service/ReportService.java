package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportService implements Writer {
    private static final char OLD_CHAR_EQUALS = '=';
    private static final char NEW_CHAR_COMA = ',';

    public String buildReport(StorageService storage) {
        StringBuilder report = new StringBuilder();
        for (Map.Entry<String, Integer> entry : storage.getStorageMap().entrySet()) {
            report.append(String.valueOf(entry).replace(OLD_CHAR_EQUALS, NEW_CHAR_COMA))
                    .append(System.lineSeparator());
        }
        return report.toString();
    }

    @Override
    public void writeData(String filePath, String report) {
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(report);
        } catch (
                IOException e) {
            throw new RuntimeException("Cannot write to file at " + filePath, e);
        }
    }
}
