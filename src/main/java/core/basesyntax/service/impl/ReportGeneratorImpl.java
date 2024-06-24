package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        return "fruit,quantity" + Storage.reports.entrySet().stream()
                .map(entry -> String.format("%s%s,%d",
                        System.lineSeparator(),
                        entry.getKey(),
                        entry.getValue()))
                .collect(Collectors.joining());
    }
}
