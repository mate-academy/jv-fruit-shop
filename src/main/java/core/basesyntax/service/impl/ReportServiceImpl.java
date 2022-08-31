package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADERS = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        String report = Storage.getData().entrySet().stream()
                .map(totalFruits -> totalFruits.getKey() + COMMA + totalFruits.getValue()
                        + System.lineSeparator())
                .collect(Collectors.joining());
        return HEADERS + System.lineSeparator() + report;
    }
}
