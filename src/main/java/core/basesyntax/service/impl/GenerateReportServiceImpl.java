package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.GenerateReportService;
import java.util.Map;

public class GenerateReportServiceImpl implements GenerateReportService {
    private static final String SEPARATOR = ",";
    private static final String TITLE = "fruit,quantity";

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder(TITLE + System.lineSeparator());

        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
