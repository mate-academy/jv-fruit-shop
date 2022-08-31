package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADERS = "fruit,quantity";

    @Override
    public String getReport() {
        String report = Storage.getAll().entrySet().stream()
                .map(totalFruits -> totalFruits.getKey() + "," + totalFruits.getValue()
                        + System.lineSeparator())
                .collect(Collectors.joining());
        return HEADERS + System.lineSeparator() + report;
    }
}
