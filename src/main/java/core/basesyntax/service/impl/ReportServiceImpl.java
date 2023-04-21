package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public String generateReport(Map<String, Integer> fruitData) {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : fruitData.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",").append(entry.getValue());
        }
        return report.toString();
    }
}
