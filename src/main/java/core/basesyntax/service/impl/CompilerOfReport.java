package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;
import java.util.Map;
import java.util.Set;

public class CompilerOfReport implements ReportCreator {
    private static final String REPORT_TOPIC = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport(Set<Map.Entry<Fruit, Integer>> entries) {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_TOPIC).append(System.lineSeparator());
        if (entries == null || entries.isEmpty()) {
            return builder.toString();
        }

        for (Map.Entry<Fruit, Integer> fruitEntry : entries) {
            builder.append(fruitEntry.getKey()).append(SEPARATOR).append(fruitEntry.getValue());
            builder.append(System.lineSeparator());
        }
        builder.delete(builder.lastIndexOf(System.lineSeparator()), builder.length());
        return builder.toString();
    }
}
