package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport(Map<String, Integer> fruitsMap) {
        StringBuilder reportBuilder = new StringBuilder(HEADER)
                .append(System.lineSeparator());
        fruitsMap.forEach((key, value) -> reportBuilder.append(key)
                .append(SEPARATOR)
                .append(value)
                .append(System.lineSeparator()));
        return reportBuilder.toString();
    }
}
