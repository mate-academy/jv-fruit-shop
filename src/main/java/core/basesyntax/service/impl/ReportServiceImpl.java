package java.core.basesyntax.service.impl;

import java.util.Map;
import java.core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public String createReport(Map<String, Integer> fruits) {
        StringBuilder report = new StringBuilder(REPORT_HEADER + System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : fruits.entrySet()) {
            report.append(fruit.getKey())
                    .append(",")
                    .append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
