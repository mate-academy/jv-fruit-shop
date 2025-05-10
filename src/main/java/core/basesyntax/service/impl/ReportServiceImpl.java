package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String NEW_LINE = System.lineSeparator();

    @Override
    public String getReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        report.append(TITLE);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(NEW_LINE)
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
