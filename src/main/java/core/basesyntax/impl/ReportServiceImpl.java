package core.basesyntax.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport(Map<String, Integer> fruitStorage) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(REPORT_TITLE);
        for (Map.Entry<String, Integer> entry: fruitStorage.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
