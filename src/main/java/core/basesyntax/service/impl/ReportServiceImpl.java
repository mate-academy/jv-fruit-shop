package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder reportText = new StringBuilder("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            reportText.append(entry.getKey()).append(SEPARATOR)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return reportText.toString();
    }
}
