package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import core.basesyntax.storage.Storage;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEAD_OF_REPORT = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        String report = Storage.storage.entrySet().stream()
                .map(mapValues -> new StringBuilder()
                        .append(mapValues.getKey().getName())
                        .append(SEPARATOR).append(mapValues.getValue().toString())
                        .append(System.lineSeparator()).toString())
                .collect(Collectors.joining());
        return new StringBuilder(HEAD_OF_REPORT)
                .append(System.lineSeparator())
                .append(report).toString();
    }
}
