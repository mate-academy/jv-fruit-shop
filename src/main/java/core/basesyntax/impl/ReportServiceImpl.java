package core.basesyntax.impl;

import core.basesyntax.fruitstorge.FruitStorage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        return "fruit, quantity" + System.lineSeparator()
                + FruitStorage.fruitStorage.entrySet().stream()
                .map(e -> e.getKey() + " " + e.getValue() + System.lineSeparator())
                .collect(Collectors.joining()).trim();
    }
}
