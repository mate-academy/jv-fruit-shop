package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReporterService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReporterServiceImpl implements ReporterService {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String CSV_COLUMNS_SPLITTER = ",";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> row : Storage.storage.entrySet()) {
            String reportLine = row.getKey().getName() + CSV_COLUMNS_SPLITTER
                    + row.getValue() + System.lineSeparator();
            builder.append(reportLine);
        }
        return builder.toString();
    }
}
