package core.basesyntax.services;

import java.util.Map;

public class ReportService {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String SYMBOL = ",";

    public String generateReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        report.append(FIRST_LINE);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append("\n")
                    .append(entry.getKey())
                    .append(SYMBOL)
                    .append(entry.getValue());
        }
        String resultReport = report.toString();
        report.setLength(0);
        return resultReport;
    }
}
