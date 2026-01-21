package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteReportImpl implements WriteReport {
    @Override
    public void writeReport(String report, String filePath) {
        if (report == null || filePath == null) {
            throw new RuntimeException("Report and FilePath cannot be null");
        }

        try {
            Files.write(Path.of(filePath), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + filePath, e);
        }
    }
}
