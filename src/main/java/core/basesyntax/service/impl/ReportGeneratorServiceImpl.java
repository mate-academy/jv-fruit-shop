package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGeneratorService;
import java.util.Map;
import java.util.Set;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String COMMA_SEPARATOR = ",";
    private static final String REPORT_FIRST_LINE = "fruit,quantity";

    @Override
    public String generate() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_FIRST_LINE);
        Set<Map.Entry<String, Integer>> storageEntry = Storage.storageMap.entrySet();
        for (Map.Entry<String, Integer> entry : storageEntry) {
            String fruit = entry.getKey();
            int amount = entry.getValue();
            stringBuilder.append(System.lineSeparator())
                    .append(fruit)
                    .append(COMMA_SEPARATOR)
                    .append(amount);
        }
        return stringBuilder.toString();
    }
}
