package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    @Override
    public void writeToFile() {
        ReportService reportService = new ReportServiceImpl();
        String reportForFile = reportService.createReport();
        try {
            Files.writeString(Path.of(REPORT_FILE_PATH), reportForFile);
        } catch (IOException e) {
            throw new RuntimeException("Error when writing to file " + REPORT_FILE_PATH, e);
        }
    }
}
