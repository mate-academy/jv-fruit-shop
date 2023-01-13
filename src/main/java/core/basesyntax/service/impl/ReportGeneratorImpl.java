package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(HEADER);
        for (Map.Entry<String, Integer> fruit : Storage.fruits.entrySet()) {
            builder.append("\n")
                    .append(fruit.getKey())
                    .append(",")
                    .append(fruit.getValue());
        }
        return builder.toString();
    }
}
