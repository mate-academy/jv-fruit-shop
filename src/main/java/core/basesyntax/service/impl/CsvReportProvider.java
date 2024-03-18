package core.basesyntax.service.impl;

import core.basesyntax.model.Storage;
import core.basesyntax.service.ReportProvider;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CsvReportProvider implements ReportProvider {
    public static final String REPORT_TITLE = "fruit,quantity";
    public static final String COLUMN_SEPARATOR = ",";
    public static final String ROW_SEPARATOR = System.lineSeparator();

    private final Consumer<Integer> positiveValueCheck = operationValue -> {
        if (operationValue < 0) {
            throw new RuntimeException("Operation value cannot be negative");
        }
    };

    @Override
    public String provide() {
        String header = REPORT_TITLE + ROW_SEPARATOR;
        return header + Storage.stream()
                .peek(trans -> positiveValueCheck.accept(trans.getValue()))
                .map(trans -> trans.getKey() + COLUMN_SEPARATOR + trans.getValue())
                .collect(Collectors.joining(ROW_SEPARATOR));
    }
}
