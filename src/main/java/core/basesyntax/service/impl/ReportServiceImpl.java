package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMN_NAMES = "fruit,quantity";
    private static final String DELIMITER = ",";
    private Map<String, Integer> balance;

    public ReportServiceImpl(Map<String, Integer> balance) {
        this.balance = balance;
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!balance.isEmpty()) {
            stringBuilder.append(COLUMN_NAMES);
            for (Map.Entry<String, Integer> item : balance.entrySet()) {
                stringBuilder.append(System.lineSeparator())
                        .append(item.getKey())
                        .append(DELIMITER)
                        .append(item.getValue());
            }
        }
        return stringBuilder.toString();
    }
}
