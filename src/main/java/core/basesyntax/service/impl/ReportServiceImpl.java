package core.basesyntax.service.impl;

import core.basesyntax.db.StockBalance;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMN_NAMES = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String get(Map<String, Integer> balance) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!StockBalance.STOCK_BALANCE.isEmpty()) {
            stringBuilder.append(COLUMN_NAMES);
            for (Map.Entry<String, Integer> item : StockBalance.STOCK_BALANCE.entrySet()) {
                stringBuilder.append(System.lineSeparator())
                        .append(item.getKey())
                        .append(DELIMITER)
                        .append(item.getValue());
            }
        }
        return stringBuilder.toString();
    }
}
