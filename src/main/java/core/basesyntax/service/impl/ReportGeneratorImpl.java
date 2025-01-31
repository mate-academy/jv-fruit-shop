package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.stream.Collectors;
import static core.basesyntax.Main.COMMA_SEPARATOR;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generateReport(Map<String, Integer> inventory) {
        StringBuilder reportBuilder = new StringBuilder("fruit,quantity\n");
        String reportBody = inventory.entrySet()
                .stream()
                .map(entry -> entry.getKey() + COMMA_SEPARATOR + entry.getValue())
                .collect(Collectors.joining("\n"));
        reportBuilder.append(reportBody);
        return reportBuilder.toString();
    }
}
