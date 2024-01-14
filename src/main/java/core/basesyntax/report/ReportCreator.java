package core.basesyntax.report;

import java.util.Map;

public class ReportCreator {
    private static final String REPORT_HEADER = "fruit,quantity";

    public String createReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_HEADER).append(System.lineSeparator());
        storage.forEach((key, value) -> {
            report.append(key)
                    .append(",")
                    .append(value)
                    .append(System.lineSeparator());
        });
        return report.toString();
    }
}
