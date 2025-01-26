package result;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generateReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");

        storage.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> report
                        .append(entry.getKey())
                        .append(",")
                        .append(entry.getValue())
                        .append("\n"));

        return report.toString();
    }
}
