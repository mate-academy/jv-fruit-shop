package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity\n";

    @Override
    public String generateReport() {
        String report = Storage.getAllFruits().entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue() + System.lineSeparator())
                .collect(Collectors.joining("", REPORT_HEADER, ""));

        return report;
    }
}
