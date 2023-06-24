package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String OUTPUT_HEADER = "fruit,quantity";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        return Storage.storage.entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.joining(NEW_LINE, OUTPUT_HEADER + NEW_LINE, NEW_LINE));
    }
}
