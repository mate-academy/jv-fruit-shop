package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";

    @Override
    public String createReport(Map<String, Integer> map) {
        StringBuilder report = new StringBuilder("fruit,quantity");
        report.append(System.lineSeparator());
        for (Map.Entry entry: map.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
