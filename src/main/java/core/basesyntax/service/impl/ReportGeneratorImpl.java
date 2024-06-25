package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import java.util.stream.Collectors;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        return "fruit,quantity" + Storage.readDb().entrySet().stream()
                .map(entry -> String.format("%s%s,%d",
                        System.lineSeparator(),
                        entry.getKey(),
                        entry.getValue()))
                .collect(Collectors.joining());
    }
}
