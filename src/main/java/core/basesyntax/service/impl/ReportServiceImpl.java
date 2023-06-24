package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }
        return builder.toString();
    }
}
