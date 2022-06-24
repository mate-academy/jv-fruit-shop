package core.basesyntax.service.impl;

import core.basesyntax.service.LineGenerator;
import java.util.Map;
import java.util.stream.Collectors;

public class LineGeneratorImpl implements LineGenerator {
    private static final String COLUMNS_NAME = " fruit,quantity";

    @Override
    public String createReport(Map<String, Integer> fruitReport) {
        return COLUMNS_NAME + fruitReport.entrySet().stream()
                .map(m -> System.lineSeparator() + String.format("%s,%d", m.getKey(), m.getValue()))
                .collect(Collectors.joining());
    }
}
