package core.basesyntax.service;

import core.basesyntax.model.Storage;
import java.util.List;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String DATA_SEPARATOR = ",";

    @Override
    public List<String> createReport() {
        return Storage.FRUIT_COUNT.entrySet().stream()
                .map(v -> v.getKey() + DATA_SEPARATOR + v.getValue())
                .collect(Collectors.toList());
    }
}
