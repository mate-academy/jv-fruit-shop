package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String FOOTER = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER);
        for (var storage : Storage.fruits.entrySet()) {
            report.append(System.lineSeparator())
                    .append(storage.getKey())
                    .append(FOOTER)
                    .append(Storage.fruits.get(storage.getKey()));
        }
        return report.toString();
    }
}
