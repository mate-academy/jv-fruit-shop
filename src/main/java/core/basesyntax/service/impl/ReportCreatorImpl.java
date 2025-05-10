package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruits: Storage.fruits.entrySet()) {
            stringBuilder.append(fruits.getKey())
                    .append(SEPARATOR)
                    .append(fruits.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
