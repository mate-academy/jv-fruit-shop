package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(FRUIT).append(SEPARATOR).append(QUANTITY);
        for (Map.Entry<String, Integer> entry : Storage.fruitTransactionsMap.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey()).append(SEPARATOR).append(entry.getValue());
        }
        return builder.toString();
    }
}
