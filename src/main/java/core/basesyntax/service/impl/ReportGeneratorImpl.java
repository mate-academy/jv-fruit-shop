package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(FRUIT).append(SEPARATOR).append(QUANTITY).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.getStorage().entrySet()) {
            report.append(entry.getKey()).append(SEPARATOR).append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
