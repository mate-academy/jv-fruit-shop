package core.basesyntax.service;

import core.basesyntax.storage.Storage;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String REPORT_STARTING = "fruit,quantity" + System.lineSeparator();

    @Override
    public String createReport() {
        return Storage.storage.entrySet().stream()
                .map(s -> s.getKey().getName() + "," + s.getValue())
                .collect(Collectors.joining(System.lineSeparator(), REPORT_STARTING, ""));
    }
}
