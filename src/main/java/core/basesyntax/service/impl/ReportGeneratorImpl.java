package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER_OF_REPORT = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String getReport() {
        String reportBody = Storage.getAllFruits().entrySet().stream()
                .map(entry -> entry.getKey() + DELIMITER + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        return HEADER_OF_REPORT + System.lineSeparator() + reportBody;
    }
}
