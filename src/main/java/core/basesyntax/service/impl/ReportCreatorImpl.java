package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import core.basesyntax.storage.Storage;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String COLUMN_SPLIT_STRING = ",";

    @Override
    public String create() {
        return Storage.fruits.entrySet()
                .stream()
                .map(entry -> entry.getKey() + COLUMN_SPLIT_STRING + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator(), HEADER, ""));
    }
}
