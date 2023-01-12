package core.basesyntax.service.impl;

import core.basesyntax.service.GenerateReport;
import java.util.Map;

public class GenerateReportImpl implements GenerateReport {
    private static final String HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";

    public String generateReport(Map<String, Integer> mapFruit) {
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : mapFruit.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
