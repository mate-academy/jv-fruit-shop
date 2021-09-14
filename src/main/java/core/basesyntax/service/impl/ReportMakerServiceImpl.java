package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportMakerService;
import java.util.Map;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = "\n";
    private static final String FIRST_ROW = "fruit,quantity";

    @Override
    public String getReport(Map<Fruit, Integer> map) {
        StringBuilder builder = new StringBuilder(FIRST_ROW);
        for (Map.Entry<Fruit, Integer> entry : map.entrySet()) {
            builder.append(LINE_SEPARATOR)
                    .append(getSingleFruitReport(entry));
        }
        return builder.toString();
    }

    private String getSingleFruitReport(Map.Entry<Fruit, Integer> entry) {
        return entry.getKey().getName()
                + COMMA
                + entry.getValue();
    }
}
