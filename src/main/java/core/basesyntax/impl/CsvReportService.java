package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class CsvReportService implements ReportService {
    private static final String TOP_ROW = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(TOP_ROW);
        for (String fruit : Storage.FRUITS.keySet()) {
            reportBuilder
                    .append(fruit)
                    .append(COMMA)
                    .append(Storage.FRUITS.get(fruit))
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
