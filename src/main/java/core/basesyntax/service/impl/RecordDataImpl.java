package core.basesyntax.service.impl;

import core.basesyntax.service.RecordData;
import java.util.Map;

public class RecordDataImpl implements RecordData {
    private static final String SEPARATOR = ",";

    @Override
    public String recorder(Map<String, Integer> fruits) {
        String header = "fruit, quantity";
        StringBuilder builder = new StringBuilder();
        builder.append(header).append(System.lineSeparator());
        for (Map.Entry<String, Integer> items : fruits.entrySet()) {
            builder.append(items.getKey())
                    .append(SEPARATOR)
                    .append(items.getValue());
        }
        return builder.toString();
    }
}

