package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String FIRST_COLUMN_HEADER = "fruit";
    private static final String SECOND_COLUMN_HEADER = "quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(FIRST_COLUMN_HEADER)
                .append(SEPARATOR).append(SECOND_COLUMN_HEADER);
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey()).append(SEPARATOR).append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
