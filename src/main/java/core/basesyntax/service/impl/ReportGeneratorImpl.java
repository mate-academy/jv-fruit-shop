package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FIRST_STRING_OF_REPORT = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder(FIRST_STRING_OF_REPORT);
        for (Map.Entry<Fruit, Integer> entry : Storage.fruitInventory.entrySet()) {
            report.append("\n").append(entry.getKey()).append(SEPARATOR).append(entry.getValue());
        }
        return report.toString();
    }
}
