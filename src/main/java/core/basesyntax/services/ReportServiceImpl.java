package core.basesyntax.services;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";

    @Override
    public String createReport(Map<Fruit, Integer> mapQuantityFruit, String titleReport) {
        StringBuilder builder = new StringBuilder();
        builder.append(titleReport);
        for (Map.Entry<Fruit, Integer> entry : mapQuantityFruit.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(COMMA)
                    .append(entry.getValue());
        }
        return builder.append(System.lineSeparator()).toString();
    }
}
