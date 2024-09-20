package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<String> generateReport() {
        return Storage.fruits.values().stream()
                .map(fruit -> fruit.getName() + "," + fruit.getQuantity())
                .collect(Collectors.toList());
    }
}
