package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String CSV_COLUMNS_SPLITTER = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> row : Storage.storage.entrySet()) {
            builder.append(row.getKey().getName());
            builder.append(CSV_COLUMNS_SPLITTER);
            builder.append(row.getValue());
            builder.append(LINE_SEPARATOR);
        }
        return builder.toString();
    }
}
