package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER).append(System.lineSeparator());
        Storage.storage.forEach((key, value) -> stringBuilder.append(key.getName())
                .append(COMMA_SEPARATOR)
                .append(value)
                .append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }
}
