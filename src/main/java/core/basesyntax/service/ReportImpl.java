package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

import java.util.Map;

public class ReportImpl implements Report {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> pair : Storage.fruits.entrySet()) {
            builder.append(pair.getKey().getName())
                    .append(COMMA)
                    .append(pair.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
