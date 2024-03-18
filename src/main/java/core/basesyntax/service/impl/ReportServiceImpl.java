package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String SPLIT_SEPARATOR = ",";

    @Override
    public String createReport() {
        return HEADER + Storage.fruits.entrySet().stream()
                .map(fruit -> System.lineSeparator() + fruit.getKey() + SPLIT_SEPARATOR
                        + fruit.getValue())
                .collect(Collectors.joining());
    }
}
