package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder(HEADER).append(System.lineSeparator());
        Storage.getAll().forEach(f -> stringBuilder
                        .append(f.getKey().getName())
                        .append(COMMA).append(f.getValue())
                        .append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
