package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGeneratorService;
import java.util.Map;

public class FruitReportGeneratorService implements ReportGeneratorService {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder(HEADER + System.lineSeparator());
        for (String fruit : Storage.fruits.keySet()) {
            int quantity = Storage.fruits.entrySet().stream()
                    .filter(e -> e.getKey().equals(fruit))
                    .mapToInt(Map.Entry::getValue)
                    .sum();
            report.append(fruit).append(SEPARATOR).append(quantity).append(System.lineSeparator());
        }
        return report.toString();
    }
}
