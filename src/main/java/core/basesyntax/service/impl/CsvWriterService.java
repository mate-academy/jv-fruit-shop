package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvWriterService implements WriterService {
    @Override
    public void writeReportToFile(String data, String reportName) {
        if (Files.exists(Paths.get(reportName + ".csv"))) {
            throw new RuntimeException("A file with this name already exists");
        }
        try {
            Files.write(Paths.get(reportName + ".csv"), data.getBytes());
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't write data to the file", e);
        }
    }
}
