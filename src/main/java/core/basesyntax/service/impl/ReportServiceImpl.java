package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final Map<String, Integer> STORE = Storage.STORAGE;
    private static final String FIRST_ROW = "fruit,quantity\n";
    private static final String DELIMITER = ",";
    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(FIRST_ROW);
        for (Map.Entry<String, Integer> entry : STORE.entrySet()) {
            builder.append(entry.getKey());
            builder.append(DELIMITER);
            builder.append(entry.getValue());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
