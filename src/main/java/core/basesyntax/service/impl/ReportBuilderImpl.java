package core.basesyntax.service.impl;

import core.basesyntax.service.ReportBuilder;
import java.util.Map;

public class ReportBuilderImpl implements ReportBuilder {
    private static final String DELIMITER = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String build(Map<String, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }

        return stringBuilder.toString();
    }
}
