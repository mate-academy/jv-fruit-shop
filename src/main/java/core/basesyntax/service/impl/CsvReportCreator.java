package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreatorService;

public class CsvReportCreator implements ReportCreatorService {
    public static final String TABLE_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder(TABLE_HEADER);
        builder.append(System.lineSeparator());
        Storage.fruitsMap.entrySet().stream()
                .map(e -> e.getKey()
                .getName() + SEPARATOR + e.getValue())
                .forEach(e -> builder.append(e).append(System.lineSeparator()));
        return builder.toString();
    }
}
