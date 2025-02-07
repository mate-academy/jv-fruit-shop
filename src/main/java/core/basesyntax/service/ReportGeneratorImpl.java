package core.basesyntax.service;

import core.basesyntax.infrastructure.db.Storage;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        return Storage.STORAGE.entrySet().stream()
                .map(f -> f.getKey() + SEPARATOR + f.getValue())
                .collect(Collectors.joining(System.lineSeparator()));

    }
}
