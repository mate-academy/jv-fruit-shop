package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String generateReport(Map<String, Integer> data) {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        report.append(System.lineSeparator());
        data.entrySet().stream()
                .map(entry -> entry.getKey() + COMMA_SEPARATOR + entry.getValue())
                .forEach(s -> report.append(s).append(System.lineSeparator()));
        return report.toString().trim();
    }
}
