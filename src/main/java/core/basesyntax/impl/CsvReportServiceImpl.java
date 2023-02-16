package core.basesyntax.impl;

import java.util.stream.Collectors;
import core.basesyntax.database.Storage;
import core.basesyntax.service.CsvReportService;

public class CsvReportServiceImpl implements CsvReportService {
    private static final String TITLE = "fruit,quantity\n";
    private static final String DATA_SEPARATOR = ",";

    @Override
    public String getReport() {
        return TITLE + Storage.fruitStorage.entrySet().stream()
                .map(s -> s.getKey() + DATA_SEPARATOR + s.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}

