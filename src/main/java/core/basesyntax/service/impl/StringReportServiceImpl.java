package core.basesyntax.service.impl;

import core.basesyntax.service.StringReportService;
import java.util.Map;

public class StringReportServiceImpl implements StringReportService {
    private static final String CSV_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReportString(Map<String, Integer> report) {
        StringBuilder reportStringBuilder = new StringBuilder();
        reportStringBuilder.append(CSV_HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            String line = entry.getKey() + SEPARATOR + entry.getValue();
            reportStringBuilder.append(line).append(System.lineSeparator());
        }
        return reportStringBuilder.toString();
    }
}
