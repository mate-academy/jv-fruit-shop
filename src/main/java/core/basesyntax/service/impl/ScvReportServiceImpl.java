package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ScvReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport(Map<String, Integer> info) {
        StringBuilder report = new StringBuilder(HEADER);
        report.append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : info.entrySet()) {
            report.append(fruit.getKey()).append(",")
                    .append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
