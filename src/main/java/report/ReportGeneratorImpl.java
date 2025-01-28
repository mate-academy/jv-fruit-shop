package report;

import core.basesyntax.operation.Storage; // Import the Storage class

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String generateReport() { // Remove the Map parameter
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());

        Storage.storage.entrySet() // Use Storage.storage directly
                .stream()
                .forEach(entry -> report
                        .append(entry.getKey())
                        .append(COMMA)
                        .append(entry.getValue())
                        .append(System.lineSeparator()));
        return report.toString();
    }
}
