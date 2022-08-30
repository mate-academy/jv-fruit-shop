package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER_TITLE = "fruit, quantity";
    private static final String SPLITTER = ",";

    @Override
    public String createReport(Map<String, Integer> data) {
        StringBuilder builder = new StringBuilder();
        return builder.append(HEADER_TITLE)
                .append(System.lineSeparator())
                .append(data.entrySet().stream()
                        .map(s -> s.getKey() + SPLITTER + s.getValue())
                        .collect(Collectors.joining(System.lineSeparator())))
                .toString();
    }
}
