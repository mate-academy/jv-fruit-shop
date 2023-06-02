package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String COMA_SEPARATOR = ",";

    @Override
    public String generateReport(Map<String, Integer> fruitsMap) {
        StringBuilder reportBuilder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : fruitsMap.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMA_SEPARATOR)
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
