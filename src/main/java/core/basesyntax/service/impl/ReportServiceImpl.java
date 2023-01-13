package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String getReport(Map<String, Integer> storage) {
        StringBuilder reportBuilder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
