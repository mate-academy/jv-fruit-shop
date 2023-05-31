package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writeReport(String report, String filePath) {
        try {
            Files.write(Path.of(filePath), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write report to file: " + filePath, e);
        }
    }
}
