package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity\n";
    private static final String DATE_SEPARATOR = ",";
    private static final Map<String, Integer> FRUIT_MAP = Storage.fruits;

    @Override
    public String report() {
        return TITLE + FRUIT_MAP.keySet().stream()
                .map(k -> k + DATE_SEPARATOR + FRUIT_MAP.get(k) + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
