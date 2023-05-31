package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String COMA_SEPARATOR = ",";
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();

    @Override
    public String createReport() {
        return Storage.FRUITS.entrySet().stream()
                .map(entry -> entry.getKey() + COMA_SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator(),
                        TITLE, System.lineSeparator()));
    }
}
