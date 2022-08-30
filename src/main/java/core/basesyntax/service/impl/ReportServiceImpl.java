package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_FOR_REPORT = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport(Set<Map.Entry<String, Integer>> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE_FOR_REPORT).append(System.lineSeparator());
        String dataReport = storage.stream()
                .map(e -> e.getKey() + SEPARATOR + e.getValue().toString())
                .collect(Collectors.joining(System.lineSeparator()));
        return stringBuilder.append(dataReport).toString();
    }
}
