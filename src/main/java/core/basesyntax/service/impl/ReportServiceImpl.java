package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDatabase;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit, quantity" + System.lineSeparator();

    @Override
    public String generateReport() {
        return FruitDatabase.database.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue() + System.lineSeparator())
                .collect(Collectors.joining("", REPORT_HEADER, ""));
    }
}
