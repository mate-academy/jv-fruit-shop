package report;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String generateReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());

        storage.entrySet()
                .stream()
                .forEach(entry -> report
                        .append(entry.getKey())
                        .append(COMMA)
                        .append(entry.getValue())
                        .append(System.lineSeparator()));
        return report.toString();
    }
}
