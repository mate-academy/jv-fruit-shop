package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorCsvImpl implements ReportCreator {
    public static final String DIVIDER = ",";

    @Override
    public String createReport(Map<Fruit, Integer> fruits) {
        String report = "fruit,quantity";
        StringBuilder builder = new StringBuilder(report);
        for (Map.Entry<Fruit, Integer> line : fruits.entrySet()) {
            String fruitName = line.getKey().getName();
            Integer quantity = line.getValue();
            builder.append(System.lineSeparator()).append(fruitName)
                    .append(DIVIDER).append(quantity);
        }
        return builder.append(System.lineSeparator()).toString();
    }
}
