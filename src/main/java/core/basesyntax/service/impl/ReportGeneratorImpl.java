package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport(Map<String, Integer> inventory) {
        StringBuilder report = new StringBuilder(HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            report.append(entry.getKey()).append(COMMA).append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
