package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.TransactionService;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.REPORT.entrySet()) {
            report.append(System.getProperty("line.separator"))
                    .append(entry.getKey()).append(SEPARATOR).append(entry.getValue());
        }
        return report.toString();
    }
}
