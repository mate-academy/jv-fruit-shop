package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGeneratorService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    @Override
    public String generateReport(Map<String, Integer> data) {
        StringBuilder reportBuilder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        return reportBuilder.append(data
                .entrySet()
                .stream()
                .map(e -> String.join(",", List.of(e.getKey(),String.valueOf(e.getValue()))))
                .collect(Collectors.joining(System.lineSeparator())))
                .toString();
    }
}
