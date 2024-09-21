package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<String> generateReport() {
        Map<String, Fruit> allFruits = Storage.getAllFruits();
        return allFruits.values().stream()
                .map(fruit -> fruit.getName() + "," + fruit.getQuantity())
                .collect(Collectors.toList());
    }
}
