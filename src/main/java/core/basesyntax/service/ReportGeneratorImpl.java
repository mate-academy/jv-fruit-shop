package core.basesyntax.service;

import core.basesyntax.infrastructure.db.Storage;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        return Storage.STORAGE.entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));

    }
}
