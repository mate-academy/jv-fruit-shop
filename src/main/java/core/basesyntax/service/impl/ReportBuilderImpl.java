package core.basesyntax.service.impl;

import core.basesyntax.service.ReportBuilder;
import java.util.Map;

public class ReportBuilderImpl implements ReportBuilder {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String create(Map<String, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }

        return stringBuilder.toString();
    }
}
