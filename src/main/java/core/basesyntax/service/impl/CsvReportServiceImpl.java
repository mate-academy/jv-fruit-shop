package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class CsvReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String LINE_SEPARATOR = ",";

    @Override
    public String createReport(Map<String, Integer> fruitsMap) {
        StringBuilder stringBuilder = new StringBuilder(HEADER + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitsMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(LINE_SEPARATOR)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
