package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FILE_HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public String generateReport() {
        return FILE_HEADER + FruitStorage.fruits.entrySet().stream()
                .map(element -> element.getKey() + "," + element.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
