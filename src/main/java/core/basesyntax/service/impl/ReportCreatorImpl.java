package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final char SEPARATOR = ',';

    @Override
    public String createReport(Map<String, Integer> storageFruits) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(REPORT_TITLE);
        for (Map.Entry<String, Integer> entry : storageFruits.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
