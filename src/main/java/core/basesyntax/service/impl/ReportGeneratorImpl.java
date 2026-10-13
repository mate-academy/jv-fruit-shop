package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit" + SEPARATOR + "quantity";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder(HEADER);

        for (Map.Entry<String, Integer> fruitEntry : Storage.getFruits().entrySet()) {
            builder.append(System.lineSeparator());
            builder.append(fruitEntry.getKey());
            builder.append(SEPARATOR);
            builder.append(fruitEntry.getValue());
        }

        return builder.toString();
    }
}
