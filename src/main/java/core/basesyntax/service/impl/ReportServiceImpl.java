package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.ReportService;

import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";
    private static final String FIRST_LINE = "fruit,quantity" + System.lineSeparator();

    @Override
    public String generateReport() {
        return Storage.storage.entrySet().stream()
                .map(e -> e.getKey() + SEPARATOR + e.getValue())
                .collect(Collectors.joining(System.lineSeparator()
                        , FIRST_LINE
                        , System.lineSeparator()));
    }
}
