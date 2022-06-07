package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvReportWriterService implements ReportWriterService {
    private static final String REPORT_PATH = "./src/main/resources/report.csv";

    @Override
    public void writeReport(String report) {
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new FileWriter(new File(REPORT_PATH)))) {
            bufferedWriter.write(report);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
