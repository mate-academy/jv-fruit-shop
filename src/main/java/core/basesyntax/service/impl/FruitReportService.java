package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class FruitReportService implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String calculateReport(Map<String, Integer> data) {
        StringBuilder report = new StringBuilder(HEADER);
        data.forEach((key, value)
                -> report.append(System.lineSeparator())
                .append(key).append(CSV_SEPARATOR).append(value)
        );
        return report.toString();
    }
}
