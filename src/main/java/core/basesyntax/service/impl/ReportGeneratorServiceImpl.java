package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGeneratorService;
import java.util.Map;
import java.util.Set;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String COMMA = ",";
    private static final String PREDEFINED_LINE = "fruit,quantity";

    @Override
    public String generateReport(Map<String, Integer> fruitStorageMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PREDEFINED_LINE);
        Set<Map.Entry<String, Integer>> entries = fruitStorageMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
