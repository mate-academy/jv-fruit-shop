package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreateService;
import java.util.stream.Collectors;

public class ReportCreateServiceImpl implements ReportCreateService {
    private static final String SPLITERATOR = ",";
    private static final String TITLE = "fruit,quantity";

    @Override
    public String createReport() {
        return TITLE + Storage.storageMap
                .entrySet()
                .stream()
                .map(e -> System.lineSeparator()
                        + e.getKey()
                        + SPLITERATOR
                        + e.getValue())
                .collect(Collectors.joining());
    }
}
