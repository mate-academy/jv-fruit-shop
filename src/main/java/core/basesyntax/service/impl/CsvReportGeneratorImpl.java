package core.basesyntax.service.impl;

import core.basesyntax.service.CsvReportGenerator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class CsvReportGeneratorImpl implements CsvReportGenerator {
    private static final String CSV_SPLITTER = ",";
    private static final String CSV_HEAD_ROW = "fruit,quantity";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    @Override
    public void generateReport(Map<String, Integer> data) {
        StringBuilder reportStringBuilder = new StringBuilder();
        reportStringBuilder.append(CSV_HEAD_ROW);
        data.entrySet().forEach(s -> reportStringBuilder
                .append(System.lineSeparator())
                .append(s.getKey())
                .append(CSV_SPLITTER)
                .append(s.getValue()));
        byte[] reportData = reportStringBuilder.toString().getBytes();
        try {
            Files.write(Path.of(REPORT_FILE_PATH), reportData);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file");
        }
    }
}
