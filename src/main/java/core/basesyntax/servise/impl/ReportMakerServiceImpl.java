package core.basesyntax.servise.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.servise.ReportMakerService;
import java.util.stream.Collectors;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String TITLE = "fruit,quantity" + LINE_SEPARATOR;

    @Override
    public String generateReport() {
        return Storage.balance.entrySet().stream()
                .map(entry -> new StringBuilder()
                        .append(entry.getKey())
                        .append(",")
                        .append(entry.getValue()))
                .map(StringBuilder::toString)
                .collect(Collectors.joining(LINE_SEPARATOR, TITLE, ""));
    }
}
