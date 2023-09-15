package core.basesyntax.service.impl;

import core.basesyntax.service.CreateReportService;
import core.basesyntax.storage.Storage;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String REPORT_SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();

        builder.append(REPORT_TITLE);
        Storage.STORAGE.entrySet()
                       .forEach(store -> builder.append(System.lineSeparator())
                                                .append(store.getKey())
                                                .append(REPORT_SEPARATOR)
                                                .append(store.getValue()));
        return builder.toString();
    }
}
