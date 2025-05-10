package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder(HEADER);
        reportBuilder.append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruits: Storage.fruits.entrySet()) {
            reportBuilder.append(fruits.getKey())
                    .append(SEPARATOR)
                    .append(fruits.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
