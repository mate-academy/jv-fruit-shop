package core.basesyntax.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.service.ReportInCsvService;
import java.util.stream.Collectors;

public class ReportInInCsvServiceImpl implements ReportInCsvService {
    private static final String TITLE = "fruit,quantity\n";
    private static final String DATA_SEPARATOR = ",";

    @Override
    public String getReport() {
        return TITLE + Storage.getFruitStorage().entrySet()
                .stream()
                .map(s -> s.getKey() + DATA_SEPARATOR + s.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}

