package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMN_NAMES = "fruit,quantity";
    private static final String DELIMITER = ",";
    private Storage storage;

    public ReportServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!storage.STOCK_BALANCE.isEmpty()) {
            stringBuilder.append(COLUMN_NAMES);
            for (Map.Entry<String, Integer> item : storage.STOCK_BALANCE.entrySet()) {
                stringBuilder.append(System.lineSeparator())
                        .append(item.getKey())
                        .append(DELIMITER)
                        .append(item.getValue());
            }
        }
        return stringBuilder.toString();
    }
}
