package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportCreator;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String CSV_SEPARATOR = ",";
    private static final String HEADER = "fruit" + CSV_SEPARATOR + "quantity";

    @Override
    public String createReport() {
        String report = FruitStorage.storage.entrySet().stream()
                .map(e -> String.format("%s%s%d", e.getKey(), CSV_SEPARATOR, e.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));

        return String.format("%s%n%s", HEADER, report);
    }
}
