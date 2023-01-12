package core.basesyntax.service.impl;

import java.util.Map;

public class GenerateReportImpl {
    private static final String start = "fruit,quantity";
    private static final String DELIMITER = ",";

    public String generateReport(Map<String, Integer> mapFruit) {
        StringBuilder report = new StringBuilder(start);
        for (Map.Entry<String, Integer> entry : mapFruit.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
