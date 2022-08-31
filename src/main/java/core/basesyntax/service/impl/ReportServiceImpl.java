package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.Set;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport(Set<Map.Entry<Fruit, Integer>> fruitsDataMap) {
        StringBuilder stringBuilder = new StringBuilder().append(HEADER);
        for (Map.Entry<Fruit, Integer> record : fruitsDataMap) {
            stringBuilder.append(System.lineSeparator())
                    .append(record.getKey().getName())
                    .append(COMMA)
                    .append(record.getValue());
        }
        return stringBuilder.toString();
    }
}
