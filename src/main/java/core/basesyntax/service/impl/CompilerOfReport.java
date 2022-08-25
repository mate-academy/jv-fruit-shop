package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.storage.Dao;
import java.util.Map;

public class CompilerOfReport implements ReportCreator {
    private static final String REPORT_TOPIC = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport(Dao dao) {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_TOPIC).append(System.lineSeparator());
        Map<Fruit, Integer> results = dao.getBalance();
        if (results == null || results.isEmpty()) {
            return builder.toString();
        }

        for (Fruit fruit : results.keySet()) {
            builder.append(fruit).append(SEPARATOR).append(results.get(fruit));
            builder.append(System.lineSeparator());
        }
        builder.delete(builder.lastIndexOf(System.lineSeparator()), builder.length());
        return builder.toString();
    }
}
