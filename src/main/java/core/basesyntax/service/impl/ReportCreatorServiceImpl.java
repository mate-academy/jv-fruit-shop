package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreatorService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport(Map<String, Integer> fruits) {
        return HEADER + System.lineSeparator() + getFruitsRemainder(fruits);
    }

    private String getFruitsRemainder(Map<String, Integer> fruitsRemainder) {
        return fruitsRemainder.entrySet().stream()
                .map(e -> {
                    return "" + e.getKey() + "," + e.getValue();
                })
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
