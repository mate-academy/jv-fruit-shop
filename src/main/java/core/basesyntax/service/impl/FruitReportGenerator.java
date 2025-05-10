package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class FruitReportGenerator implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder(HEADER + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            String fruit = entry.getKey();
            int quantity = entry.getValue();
            report.append(fruit).append(SEPARATOR).append(quantity).append(System.lineSeparator());
        }
        return report.toString();
    }
}
