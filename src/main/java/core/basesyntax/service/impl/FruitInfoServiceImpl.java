package core.basesyntax.service.impl;

import core.basesyntax.service.FruitInfoService;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitInfoServiceImpl implements FruitInfoService {
    @Override
    public String createReport(Map<String, Integer> groupedReport) {
        return "fruit,quantity" + System.lineSeparator()
                + groupedReport.entrySet().stream()
                .map(e -> e.getKey() + "," + e.getValue() + System.lineSeparator())
                .collect(Collectors.joining()).trim();
    }
}
