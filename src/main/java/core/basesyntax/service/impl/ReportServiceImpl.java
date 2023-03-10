package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    public static final String FIRST_LINE = "fruit,quantity";
    public static final String COMMA_SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(FIRST_LINE).append(System.lineSeparator())
                .append(Storage.fruitStorage.keySet().stream()
                        .map(k -> k
                                + COMMA_SEPARATOR
                                + Storage.fruitStorage.get(k)
                                + System.lineSeparator())
                        .collect(Collectors.joining()));
        return builder.toString();
    }
}
