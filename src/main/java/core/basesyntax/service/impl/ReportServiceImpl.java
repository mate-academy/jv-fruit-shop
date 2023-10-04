package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    private final Storage storage;

    public ReportServiceImpl() {
        this.storage = new Storage();
    }

    @Override
    public String generateReport() {
        return REPORT_TITLE + System.lineSeparator()
                + storage.getFruitsStorage().entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
