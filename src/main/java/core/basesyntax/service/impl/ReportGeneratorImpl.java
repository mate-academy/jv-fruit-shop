package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGeneratorService;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGeneratorService {
    private static final String TITLE = "fruit,quantity\n";
    private static final String DELIMITER = ",";

    @Override
    public String generateReport() {
        Map<String, Integer> records = Storage.fruits;
        StringBuilder record = new StringBuilder(TITLE);
        for (Map.Entry<String, Integer> entry : records.entrySet()) {
            record.append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return record.toString();
    }
}
