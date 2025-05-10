package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADERS = "fruit, amount" + System.lineSeparator();
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        return HEADERS + Storage.getAll().entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
