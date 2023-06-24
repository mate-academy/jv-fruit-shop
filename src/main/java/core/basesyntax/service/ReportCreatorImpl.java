package core.basesyntax.service;

import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String REPORT_TITLE = "fruit,quantity";

    @Override
    public String createReport(Map<String, Integer> fruits) {
        StringBuilder report = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey()).append(",").append(entry.getValue());
        }
        return report.toString();
    }
}
