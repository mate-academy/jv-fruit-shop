package core.basesyntax.servce.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.servce.ReportCreator;
import java.util.Map;

public class CompilerOfReport implements ReportCreator {
    private static final String REPORT_TOPIC = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport(Map<Fruit, Integer> results) {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_TOPIC).append(System.lineSeparator());
        for (Fruit fruit : results.keySet()) {
            builder.append(fruit).append(SEPARATOR).append(results.get(fruit));
            builder.append(System.lineSeparator());
        }
        builder.delete(builder.lastIndexOf(System.lineSeparator()), builder.length());
        return builder.toString();
    }
}
