package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    public static final String TITLE = "fruit,quantity";
    public static final String SEPARATOR = ",";

    @Override
    public String generate() {
        StringBuilder builder = new StringBuilder(TITLE);
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return builder.toString();
    }
}
