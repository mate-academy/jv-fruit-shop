package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGeneratorService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    @Override
    public String generateReport(Map<String, Integer> storage, String path) {
        StringBuilder reportBuilder = new StringBuilder("fruit,quantity\n");
        return reportBuilder.append(storage
                .entrySet()
                .stream()
                .map(k -> String.join(",", List.of(k.getKey(),String.valueOf(k.getValue()))))
                .collect(Collectors.joining(System.lineSeparator())))
                .toString();
    }
}
