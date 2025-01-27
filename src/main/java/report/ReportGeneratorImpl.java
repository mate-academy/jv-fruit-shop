package report;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String generateReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());

        storage.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> report
                        .append(entry.getKey())
                        .append(",")
                        .append(entry.getValue())
                        .append(System.lineSeparator()));

        return report.toString();
    }
}
