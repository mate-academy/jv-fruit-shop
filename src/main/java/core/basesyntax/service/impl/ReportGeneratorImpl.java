package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity\n";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(HEADER);
        for (var entry : Storage.storage.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}

