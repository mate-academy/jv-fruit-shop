package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String WORDS_SEPARATOR = ",";

    @Override
    public String createReport(Map<String, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(WORDS_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
