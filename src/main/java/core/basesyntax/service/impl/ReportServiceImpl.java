package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService<Storage, String> {
    private static final String EMPTY_LINE = "";
    private static final String DELIMITER = ",";

    @Override
    public String getReport(Storage data, String header) {
        return data.get().entrySet().stream()
                .map(e -> e.getKey().getName() + DELIMITER + e.getValue())
                .collect(Collectors.joining(System.lineSeparator(),
                        header + System.lineSeparator(), EMPTY_LINE));
    }
}
