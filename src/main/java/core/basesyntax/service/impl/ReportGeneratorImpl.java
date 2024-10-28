package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String generateReport(Map<String, Integer> inventoryData) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(HEADER).append(LINE_SEPARATOR);
        for (Map.Entry<String, Integer> entry : inventoryData.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return reportBuilder.toString().trim();
    }
}
