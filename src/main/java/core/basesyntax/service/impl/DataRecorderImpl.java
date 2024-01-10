package core.basesyntax.service.impl;

import core.basesyntax.service.DataRecorder;
import java.util.Map;

public class DataRecorderImpl implements DataRecorder {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit, quantity";

    @Override
    public String recorder(Map<String, Integer> fruits) {
        StringBuilder record = new StringBuilder(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> items : fruits.entrySet()) {
            record.append(items.getKey())
                    .append(SEPARATOR)
                    .append(items.getValue())
                    .append(System.lineSeparator());
        }
        return record.toString();
    }
}
