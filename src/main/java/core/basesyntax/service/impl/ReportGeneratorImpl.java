package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADERS = "fruit,quantity";
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String generateReport() {
        StringBuilder builder = new StringBuilder().append(HEADERS);
        FruitStorage.storage.forEach((key, value) -> builder
                .append(LINE_SEPARATOR)
                .append(key)
                .append(COMMA)
                .append(value));
        return builder.toString();
    }
}
