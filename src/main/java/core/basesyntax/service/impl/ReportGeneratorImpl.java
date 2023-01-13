package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_COLUMNS_NAMES = "fruit,quantity";
    private static final String ITEMS_SEPARATOR = ",";

    @Override
    public String generateReport(Map<String, Integer> map) {
        StringBuilder report = new StringBuilder(REPORT_COLUMNS_NAMES)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> storage : map.entrySet()) {
            report.append(storage.getKey())
                    .append(ITEMS_SEPARATOR)
                    .append(storage.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}

