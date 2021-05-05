package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceCsv implements ReportService {
    public static final String WORDS_DIVIDER = ",";

    @Override
    public String createReport(Map<Fruit, Integer> fruits) {
        String report = "fruit,quantity";
        StringBuilder builder = new StringBuilder(report);
        for (Map.Entry<Fruit, Integer> record : fruits.entrySet()) {
            String fruitName = record.getKey().getName();
            Integer quantity = record.getValue();
            builder.append(System.lineSeparator()).append(fruitName)
                    .append(WORDS_DIVIDER).append(quantity);
        }
        return builder.toString();
    }
}
