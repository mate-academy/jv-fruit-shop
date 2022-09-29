package core.basesyntax.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class CsvReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String createReport(Map<String, Integer> fruitStorage) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(REPORT_TITLE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry: fruitStorage.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
