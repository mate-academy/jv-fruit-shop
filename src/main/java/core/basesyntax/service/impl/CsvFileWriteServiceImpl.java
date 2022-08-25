package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriteServiceImpl implements CsvFileWriterService {
    @Override
    public void writeReportToFile(String report, String fileName) {
        try {
            Files.write(Path.of(fileName), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file " + fileName, e);
        }
    }
}
