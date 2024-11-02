package core.basesyntax.service;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String getReport(Map<String, Integer> data) {
        String body = data.entrySet().stream()
                .map(s -> s.getKey() + COMMA_SEPARATOR + s.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        return HEADER + System.lineSeparator() + body;
    }
}
