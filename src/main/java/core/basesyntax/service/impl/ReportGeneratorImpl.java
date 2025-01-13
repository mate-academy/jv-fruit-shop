package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String csvHeader = "fruit,quantity";
    private static final String elementSeparator = ",";
    private static final String lineSeparator = System.lineSeparator();

    @Override
    public String getReport(Storage storage) {
        StringBuilder report = new StringBuilder();
        report.append(csvHeader);
        for (Map.Entry<String, Integer> entry : storage.getInventory().entrySet()) {
            report.append(entry.getKey()).append(elementSeparator)
                    .append(entry.getValue()).append(lineSeparator);
        }
        return report.toString();
    }
}
