package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        Storage.fruitStorage.forEach((key, value) -> report
                .append(System.lineSeparator())
                .append(key)
                .append(SEPARATOR)
                .append(value));
        return report.toString();
    }
}
