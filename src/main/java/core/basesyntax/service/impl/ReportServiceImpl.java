package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    public static final String SEPARATOR = ",";
    public static final String FRUIT_QUANTITY = "fruit, quantity";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(FRUIT_QUANTITY).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.FRUIT_STORAGE.entrySet()) {
            builder.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
