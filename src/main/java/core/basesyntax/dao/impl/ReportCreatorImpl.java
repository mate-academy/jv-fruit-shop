package core.basesyntax.dao.impl;

import core.basesyntax.dao.ReportCreator;
import core.basesyntax.db.Storage;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String STRING = "fruit,quantity";

    @Override
    public String doReport() {
        return STRING + Storage.fruitsMap.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
