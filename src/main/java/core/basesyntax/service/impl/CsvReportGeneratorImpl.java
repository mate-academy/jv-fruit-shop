package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class CsvReportGeneratorImpl implements ReportGenerator {
    private static final String CSV_SPLITTER = ",";
    private static final String CSV_HEAD_ROW = "fruit,quantity";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    @Override
    public void generateCsvReport(Map<String, Integer> data) {
        StringBuilder reportStringBuilder = new StringBuilder();
        reportStringBuilder.append(CSV_HEAD_ROW);
        data.forEach((fruit, quantity) -> reportStringBuilder
                .append(System.lineSeparator())
                .append(fruit)
                .append(CSV_SPLITTER)
                .append(quantity));
        byte[] reportData = reportStringBuilder.toString().getBytes();
        try {
            Files.write(Path.of(REPORT_FILE_PATH), reportData);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file");
        }
    }
}
