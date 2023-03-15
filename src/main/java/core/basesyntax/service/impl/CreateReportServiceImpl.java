package core.basesyntax.service.impl;

import core.basesyntax.service.CreateReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String LINE_SEPARATOR = ",";
    private static final String FIRST_ROW = "fruits,quantity";

    @Override
    public String createReport(Map<String, Integer> data) {
        if (data.isEmpty()) {
            throw new RuntimeException("Storage can't be empty!" + data);
        }
        return FIRST_ROW + System.lineSeparator() + data.entrySet().stream()
                .map(d -> d.getKey() + LINE_SEPARATOR + d.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
