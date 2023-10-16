package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(TITLE);
        Storage.storage.entrySet().stream()
                .map(fruit -> builder.append(fruit.getKey()));
        return builder.toString();
    }
}
