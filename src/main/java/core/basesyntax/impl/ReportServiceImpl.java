package core.basesyntax.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
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

