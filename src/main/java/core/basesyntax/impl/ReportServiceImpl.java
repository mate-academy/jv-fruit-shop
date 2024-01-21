package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";
    private static final String CONTENTS = "fruit, quantity";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(CONTENTS + System.lineSeparator());
        for (Map.Entry<String, Integer> entry: Storage.storage.entrySet()) {
            builder.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
