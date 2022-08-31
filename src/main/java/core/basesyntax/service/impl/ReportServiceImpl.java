package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.Set;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_FOR_REPORT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport(Set<Map.Entry<String, Integer>> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE_FOR_REPORT).append(System.lineSeparator());
        storage.stream()
                .forEach(e -> stringBuilder.append(e.getKey()).append(COMMA)
                        .append(e.getValue()).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }
}
