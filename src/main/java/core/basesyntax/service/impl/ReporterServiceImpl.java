package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReporterService;
import java.util.stream.Collectors;

public class ReporterServiceImpl implements ReporterService {
    private static final String COMA_SEPARATOR = ",";
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();

    @Override
    public String report() {
        return Storage.storage.entrySet().stream()
                .map(entry -> entry.getKey() + COMA_SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator(),
                        TITLE, System.lineSeparator()));
    }
}
