package core.basesyntax.service.impl;

import core.basesyntax.service.ReportMaker;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportMakerImpl implements ReportMaker {
    private static final String COLUMNS_SEPARATOR = ",";
    private static final String TITLE = "fruit,quantity";

    @Override
    public String make(Map<String, Integer> fruitsMap) {
        if (fruitsMap == null) {
            throw new RuntimeException("None of the arguments can be null");
        }
        return TITLE + System.lineSeparator() + fruitsMap.entrySet()
                .stream()
                .map(i -> i.getKey() + COLUMNS_SEPARATOR + i.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
