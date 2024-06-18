package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGeneratorService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    @Override
    public String generateReport(Map<String, Integer> inventory) {
        return inventory.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining("\n", "fruit,quantity\n", ""));
    }
}
