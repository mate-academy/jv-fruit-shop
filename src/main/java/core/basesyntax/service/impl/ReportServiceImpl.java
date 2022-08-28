package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport(Map<String, Integer> data) {
        StringBuilder stringBuilder = new StringBuilder();
        return String.valueOf(stringBuilder.append("fruit").append(", quantity")
                .append(System.lineSeparator())
                .append(data.entrySet().stream()
                        .map(s -> s.getKey() + "," + s.getValue())
                        .collect(Collectors.joining(System.lineSeparator()))));
    }
}
