package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = "\n";
    private static final String PREFIX = "fruit,quantity\n";
    private static final String SUFFIX = "\n";
    private static final String DELIMITER = ",";

    @Override
    public String getReport() {
        return Storage.getAllFruits().entrySet().stream()
                .map(entry -> entry.getKey() + DELIMITER + entry.getValue())
                .collect(Collectors.joining(SEPARATOR, PREFIX, SUFFIX));
    }
}
