package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitReport;

import java.util.stream.Collectors;

public class FruitReportImpl implements FruitReport {
    private static final String TITLE = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String getReport() {
        return TITLE + System.lineSeparator()
                + Storage.storage.entrySet()
                .stream()
                .map(entry -> entry.getKey().getName()
                        + CSV_SEPARATOR
                        + entry.getValue()
                        + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
