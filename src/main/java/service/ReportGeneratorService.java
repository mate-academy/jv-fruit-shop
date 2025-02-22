package service;

import java.util.Map;

public class ReportGeneratorService {

    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final String NEW_LINE = System.lineSeparator();

    public String generateReport(Map<String, Integer> inventory) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(HEADER).append(NEW_LINE);

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }

        return reportBuilder.toString();
    }
}
