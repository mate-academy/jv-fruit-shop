package core.basesyntax.service;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String TITLE = "fruit,quantity";

    @Override
    public String getReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        report.append(TITLE).append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
