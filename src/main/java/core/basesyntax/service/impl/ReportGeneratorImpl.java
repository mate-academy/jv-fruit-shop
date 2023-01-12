package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generateReport() {
        return FruitStorage.fruits.entrySet().stream()
                .map(element -> element.getKey() + "," + element.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
