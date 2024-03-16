package core.basesyntax.service.impl;

import core.basesyntax.model.Storage;
import core.basesyntax.service.ReportProvider;
import java.util.function.Predicate;

public class CsvReportProvider implements ReportProvider {
    public static final String REPORT_TITLE = "fruit,quantity";
    public static final String COLUMN_SEPARATOR = ",";
    public static final String ROW_SEPARATOR = System.lineSeparator();

    private final Predicate<Integer> predicate = operationValue -> {
        if (operationValue < 0) {
            throw new RuntimeException("Operation value cannot be negative");
        }
        return true;
    };

    @Override
    public String make(Storage storage) {
        StringBuilder builder = new StringBuilder(REPORT_TITLE + ROW_SEPARATOR);
        storage.stream()
                .filter(n -> predicate.test(n.getValue()))
                .map(n -> n.getKey() + COLUMN_SEPARATOR + n.getValue())
                .forEach(n -> builder.append(n).append(ROW_SEPARATOR));
        return builder.toString().trim();
    }
}
