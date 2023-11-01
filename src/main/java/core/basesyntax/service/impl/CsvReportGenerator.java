package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class CsvReportGenerator implements ReportGenerator {
    private static final String COLUMN_NAMES = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String generateReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(COLUMN_NAMES);
        for (String fruit : Storage.fruits.keySet()) {
            builder.append(System.lineSeparator())
                    .append(fruit)
                    .append(COMMA)
                    .append(Storage.fruits.get(fruit));
        }
        return builder.toString();
    }
}
