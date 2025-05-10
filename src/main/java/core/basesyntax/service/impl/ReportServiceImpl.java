package core.basesyntax.service.impl;

import static core.basesyntax.db.Storage.storage;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String INDENTATION = "\t";
    private static final String SEPARATOR = ",";

    @Override
    public String create() {
        StringBuilder report = new StringBuilder()
                .append(INDENTATION).append(TITLE);
        for (Map.Entry<String, Integer> item : storage.entrySet()) {
            report.append(System.lineSeparator())
                    .append(INDENTATION)
                    .append(item.getKey())
                    .append(SEPARATOR)
                    .append(item.getValue());
        }
        return report.toString();
    }
}
