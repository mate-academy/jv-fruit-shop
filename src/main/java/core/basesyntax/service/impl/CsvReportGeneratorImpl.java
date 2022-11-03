package core.basesyntax.service.impl;

import core.basesyntax.service.CsvReportGenerator;
import java.util.Map;

public class CsvReportGeneratorImpl implements CsvReportGenerator {
    private static final String CSV_SPLITTER = ",";
    private static final String CSV_HEAD_ROW = "fruit,quantity";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    @Override
    public byte[] generateCsvReport(Map<String, Integer> data) {
        StringBuilder reportStringBuilder = new StringBuilder();
        reportStringBuilder.append(CSV_HEAD_ROW);
        data.forEach((fruit, quantity) -> reportStringBuilder
                .append(System.lineSeparator())
                .append(fruit)
                .append(CSV_SPLITTER)
                .append(quantity));
        return reportStringBuilder.toString().getBytes();
    }
}
