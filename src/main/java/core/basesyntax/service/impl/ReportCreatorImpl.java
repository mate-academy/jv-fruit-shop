package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    public static final String TABLE_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(TABLE_HEADER);
        builder.append(System.lineSeparator());
        Storage.fruitsMap.entrySet().stream()
                .map(e -> e.getKey() + SEPARATOR + e.getValue())
                .forEach(e -> builder.append(e)
                .append(System.lineSeparator()));
        return builder.toString().trim();
    }
}
