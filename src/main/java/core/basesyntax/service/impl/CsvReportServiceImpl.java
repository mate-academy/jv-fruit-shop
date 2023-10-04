package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class CsvReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String LINE_SEPARATOR = ",";

    @Override
    public String createReport(Map<String, Integer> fruitMap) {
        StringBuilder reportBuilder = new StringBuilder(HEADER + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitMap.entrySet()) {
            reportBuilder.append(entry.getKey()).append(LINE_SEPARATOR)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
