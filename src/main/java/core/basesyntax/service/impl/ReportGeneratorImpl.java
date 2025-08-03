package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder(HEADER).append(LINE_SEPARATOR);
        Storage.getStorage().forEach((key, value) ->
                builder.append(key)
                        .append(COMMA)
                        .append(value)
                        .append(LINE_SEPARATOR));
        return builder.toString().trim();
    }
}
