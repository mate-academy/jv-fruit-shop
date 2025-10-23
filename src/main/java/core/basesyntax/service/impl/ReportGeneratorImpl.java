package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String build(Map<String, Integer> fruits) {
        if (fruits == null) {
            throw new IllegalArgumentException("Fruits map cannot be null");
        }
        String body = fruits.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getKey() + COMMA + e.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        return body.isEmpty()
                ? HEADER
                : HEADER + System.lineSeparator() + body;
    }
}
