package core.basesyntax.impl;

import core.basesyntax.base.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String SCV_FILE_HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(SCV_FILE_HEADER);
        String reportBody = Storage.fruitStorage.entrySet()
                .stream()
                .map(entry -> entry.getKey() + COMMA_SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        reportBuilder.append(reportBody);
        return reportBuilder.toString();
    }
}
