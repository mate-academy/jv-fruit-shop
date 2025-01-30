package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generateReport(Map<String, Integer> inventory) {
        StringBuilder reportBuilder = new StringBuilder("fruit,quantity\n");
        String reportBody = inventory.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining("\n"));
        reportBuilder.append(reportBody);
        return reportBuilder.toString();
    }
}
