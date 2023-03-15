package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruits,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String makeReport(Map<String, Integer> fruitsMap) {
        return TITLE + System.lineSeparator() + fruitsMap.entrySet()
                .stream()
                .map(fruit -> fruit.getKey() + SEPARATOR + fruit.getValue()
                        + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
