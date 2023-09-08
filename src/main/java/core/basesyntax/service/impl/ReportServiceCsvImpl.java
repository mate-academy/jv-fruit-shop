package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceCsvImpl implements ReportService {
    private static final String HEADERS = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String createReport() {
        return HEADERS + System.lineSeparator()
                + FruitStorage.STORAGE.entrySet()
                .stream()
                .map(entry -> entry.getKey() + DELIMITER + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
