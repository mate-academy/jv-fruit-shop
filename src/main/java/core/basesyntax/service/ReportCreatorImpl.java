package core.basesyntax.service;

import core.basesyntax.storage.Storage;

public class ReportCreatorImpl implements ReportCreator {
    private static final String REPORT_STARTING = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder().append(REPORT_STARTING)
                .append(System.lineSeparator());
        Storage.storage.forEach((key, value) -> builder.append(key.getName())
                .append(COMMA)
                .append(value)
                .append(System.lineSeparator()));
        return builder.toString();
    }
}
