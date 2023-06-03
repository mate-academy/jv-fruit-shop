package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CreateReportTextService;
import java.util.HashMap;
import java.util.Map;

public class CreateReportTextServiceImpl implements CreateReportTextService {
    private static final String COMMA_SEPARATOR = ",";
    private Map<String, Integer> result = new HashMap<>();

    @Override
    public String createReportText() {
        StringBuilder report = new StringBuilder();
        Storage.fruits.forEach((key, value) -> report
                .append(key)
                .append(COMMA_SEPARATOR)
                .append(value)
                .append(System.lineSeparator()));
        return report.toString();
    }
}
