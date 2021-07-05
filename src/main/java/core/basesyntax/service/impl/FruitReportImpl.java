package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitReport;
import java.util.stream.Collectors;

public class FruitReportImpl implements FruitReport {
    private static final String TITLE = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder().append(TITLE).append(System.lineSeparator());
        return Storage.storage.entrySet()
                .stream()
                .map(entry -> builder
                        .append(entry.getKey().getName())
                        .append(CSV_SEPARATOR)
                        .append(entry.getValue()))
                .collect(Collectors.joining());
    }
}
