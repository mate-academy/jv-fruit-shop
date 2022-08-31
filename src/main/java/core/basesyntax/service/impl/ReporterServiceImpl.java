package core.basesyntax.service.impl;

import core.basesyntax.service.ReporterService;
import java.util.Map;
import java.util.Set;

public class ReporterServiceImpl implements ReporterService {
    private static final String HEADER_TITLE = "fruit,quantity";
    private static final String COMA = ",";

    @Override
    public String createReport(Set<Map.Entry<String, Integer>> data) {
        StringBuilder stringBuilder = new StringBuilder(HEADER_TITLE);
        for (Map.Entry<String, Integer> fruit : data) {
            stringBuilder.append(System.lineSeparator())
                    .append(fruit.getKey() + COMA + fruit.getValue());
        }
        return stringBuilder.toString();
    }
}
