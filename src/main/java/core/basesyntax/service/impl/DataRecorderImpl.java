package core.basesyntax.service.impl;

import core.basesyntax.service.DataRecorder;
import java.util.Map;

public class DataRecorderImpl implements DataRecorder {
    private static final String HEADER = "fruit, quantity";

    @Override
    public String recordData(Map<String, Integer> fruits) {
        StringBuilder recordBuilder = new StringBuilder(HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> items : fruits.entrySet()) {
            recordBuilder
                    .append(items.getKey())
                    .append(",")
                    .append(items.getValue())
                    .append(System.lineSeparator());
        }
        return recordBuilder.toString();
    }
}
