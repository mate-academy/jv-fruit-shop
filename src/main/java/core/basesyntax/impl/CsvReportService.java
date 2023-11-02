package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class CsvReportService implements ReportService {
    private static final String TOP_ROW = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(TOP_ROW);
        for (String fruit : Storage.FRUITS.keySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(fruit)
                    .append(COMMA)
                    .append(Storage.FRUITS.get(fruit));
        }
        return reportBuilder.toString();
    }
}
