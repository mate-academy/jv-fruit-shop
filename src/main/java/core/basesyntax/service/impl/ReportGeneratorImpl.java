package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport(Storage storage) {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : storage.getFruitQuantities().entrySet()) {
            report.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return report.toString();
    }
}
