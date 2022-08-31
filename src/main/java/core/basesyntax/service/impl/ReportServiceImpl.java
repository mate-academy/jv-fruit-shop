package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder(HEADER).append(System.lineSeparator());
        Storage.getAll().forEach((key, value) ->
                stringBuilder.append(key.getName()).append(",")
                        .append(value).append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
