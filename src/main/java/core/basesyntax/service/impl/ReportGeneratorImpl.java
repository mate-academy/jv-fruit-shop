package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REGEX = ",";

    @Override
    public String makeReport(Map<String, Integer> dataFromStorage) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> map : dataFromStorage.entrySet()) {
            builder
                    .append(map.getKey())
                    .append(REGEX)
                    .append(map.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
