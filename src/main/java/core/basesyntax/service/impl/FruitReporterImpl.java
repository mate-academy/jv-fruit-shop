package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitReporter;
import java.util.Map;

public class FruitReporterImpl implements FruitReporter {
    private StringBuilder stringBuilder;

    public FruitReporterImpl() {
        stringBuilder = new StringBuilder();
    }

    @Override
    public String report(Map<Fruit, Integer> fruitsStorage) {
        stringBuilder.append("fruit,quantity");
        for (Map.Entry<Fruit, Integer> fruitEntry : fruitsStorage.entrySet()) {
            stringBuilder.append(System.lineSeparator()
                    + fruitEntry.getKey().getFruitName() + ","
                    + fruitEntry.getValue());
        }
        return stringBuilder.toString();
    }
}
