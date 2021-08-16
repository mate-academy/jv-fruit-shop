package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitReportService;

public class FruitReportServiceImpl implements FruitReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder().append(TITLE)
                .append(System.lineSeparator());
        Storage.storage.entrySet().stream()
                .forEach(e -> report.append(e.getKey().getName())
                        .append(SEPARATOR)
                        .append(e.getValue())
                        .append(System.lineSeparator()));
        return report.toString();
    }
}
