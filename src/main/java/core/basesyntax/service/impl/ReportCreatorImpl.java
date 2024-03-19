package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport(Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder();
        builder.append(HEADER)
                .append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            builder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return builder.toString();
    }
}
