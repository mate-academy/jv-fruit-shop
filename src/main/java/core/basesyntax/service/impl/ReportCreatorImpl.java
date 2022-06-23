package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String SEPARATOR = ",";
    private static final String HEADING = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(HEADING)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> record : Storage.fruits.entrySet()) {
            stringBuilder.append(record.getKey())
                    .append(System.lineSeparator())
                    .append(SEPARATOR)
                    .append(record.getValue());
        }
        return stringBuilder.toString();
    }
}
