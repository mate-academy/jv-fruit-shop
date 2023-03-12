package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final Map<Fruit, Integer> STORAGE = Storage.fruits;
    private static final String LINE_END = System.lineSeparator();
    private static final String NAME_OF_COLUMNS = "fruit,quantity" + LINE_END;
    private static final String SPLITTER = ",";

    @Override
    public String createReport() {
        String report = NAME_OF_COLUMNS;
        report += STORAGE.keySet().stream()
                .map(k -> k.getName() + SPLITTER + STORAGE.get(k) + LINE_END)
                .collect(Collectors.joining());
        return report;
    }
}
