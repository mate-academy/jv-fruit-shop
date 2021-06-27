package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String REPORT_FIRST_LINE = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String getFruitsReport(ServiceWriter writer, Map<Fruit, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder(REPORT_FIRST_LINE);
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
