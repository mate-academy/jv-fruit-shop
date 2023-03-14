package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreatorService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    public static final String TITLE = "fruit,quantity";
    public static final String COMMA_SEPARATOR = ",";

    @Override
    public String createReport(Map<String, Integer> fruits) {
        if (fruits == null) {
            throw new RuntimeException("Map cannot contains null");
        }
        return TITLE + System.lineSeparator()
                + fruits.entrySet().stream()
                .map(e -> e.getKey() + COMMA_SEPARATOR + e.getValue() + System.lineSeparator())
                .collect(Collectors.joining()).trim();
    }
}
