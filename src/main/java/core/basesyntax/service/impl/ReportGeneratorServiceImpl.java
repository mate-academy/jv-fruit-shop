package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGeneratorService;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String COMMA = ",";
    private static final String PREDEFINED_LINE = "fruit,quantity";

    @Override
    public String generateReport(Map<String, Integer> fruitStorageMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PREDEFINED_LINE);
        fruitStorageMap.entrySet().stream()
                .forEach(e -> stringBuilder
                .append(System.lineSeparator())
                .append(e.getKey())
                .append(COMMA)
                .append(e.getValue()));
        return stringBuilder.toString();
    }
}
