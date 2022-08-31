package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.Set;

public class ReportServiceImpl implements ReportService {
    private static final String HEAD_REPORT = "fruit,quantity" + System.lineSeparator();

    @Override
    public String create(Set<Map.Entry<Fruit, Integer>> fruitsDataMap) {
        StringBuilder stringBuilder = new StringBuilder(HEAD_REPORT);
        for (Map.Entry<Fruit, Integer> entry : fruitsDataMap) {
            stringBuilder
                    .append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
