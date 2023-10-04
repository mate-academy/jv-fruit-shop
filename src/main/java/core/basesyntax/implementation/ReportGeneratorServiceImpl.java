package core.basesyntax.implementation;

import core.basesyntax.database.Storage;
import core.basesyntax.service.ReportGeneratorService;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();
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
