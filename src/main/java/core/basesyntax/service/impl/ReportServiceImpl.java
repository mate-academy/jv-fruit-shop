package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR_IN_LINE = ", ";
    private static final StringBuilder report = new StringBuilder();

    @Override
    public String generateReport(Map<String, Integer> db) {
        for (String key : db.keySet()) {
            report
                    .append(key)
                    .append(SEPARATOR_IN_LINE)
                    .append(db.get(key))
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
