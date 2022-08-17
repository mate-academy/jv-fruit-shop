package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String createReport(Map<String, Integer> dataFromStorage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);
        dataFromStorage.forEach((key, value) -> stringBuilder
                .append(System.lineSeparator())
                .append(key)
                .append(DELIMITER)
                .append(value));
        return stringBuilder.toString();
    }
}
