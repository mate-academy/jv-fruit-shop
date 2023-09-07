package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGeneratorService;
import java.util.stream.Collectors;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    @Override
    public String generateReport() {
        return "fruit,quantity" + System.lineSeparator()
                + Storage.STORAGE.entrySet().stream()
                        .map(entry -> entry.getKey() + "," + entry.getValue())
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}
