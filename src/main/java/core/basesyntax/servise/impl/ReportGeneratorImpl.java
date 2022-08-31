package core.basesyntax.servise.impl;

import core.basesyntax.servise.ReportGenerator;
import core.basesyntax.storage.Storage;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEAD_OF_REPORT = "fruit,quantity\n";
    private static final String LINE_SEPARATOR = "\n";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        String report = Storage.storage.entrySet().stream()
                .map(n -> new StringBuilder()
                        .append(n.getKey().getFruit())
                        .append(SEPARATOR).append(n.getValue().toString())
                        .append(LINE_SEPARATOR).toString())
                .collect(Collectors.joining());
        return new StringBuilder(HEAD_OF_REPORT).append(report).toString();
    }
}
