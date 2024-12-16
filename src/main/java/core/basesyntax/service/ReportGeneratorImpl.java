package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity");
        List<String> fruits = FruitStorage.fruits.entrySet().stream()
                .map(e -> e.getKey() + "," + e.getValue())
                .toList();
        for (String fruit : fruits) {
            builder.append(System.lineSeparator()).append(fruit);
        }
        return builder.toString();
    }
}
