package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String INFO_LINE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport(Map<String, Integer> fruits) {
        StringBuilder reportBuilder = new StringBuilder(INFO_LINE)
                .append(System.lineSeparator());
        fruits.forEach((key, value) -> reportBuilder.append(key)
                .append(SEPARATOR)
                .append(value)
                .append(System.lineSeparator()));
        return reportBuilder.toString();
    }
}
