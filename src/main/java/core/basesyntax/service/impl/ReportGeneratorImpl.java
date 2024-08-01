package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FIELDS_NAMES = "fruit,quantity\n";

    @Override
    public String generateReport() {
        String builder = Storage.getAllFruits().entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue() + "\n")
                .collect(Collectors.joining("", FIELDS_NAMES, ""));

        return builder;
    }
}
