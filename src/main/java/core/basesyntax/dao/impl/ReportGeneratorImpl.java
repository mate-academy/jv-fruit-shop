package core.basesyntax.dao.impl;

import core.basesyntax.dao.ReportGenerator;
import core.basesyntax.db.FruitStorage;

public class ReportGeneratorImpl implements ReportGenerator {
    private final FruitStorage fruitStorage;

    public ReportGeneratorImpl(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity\n");

        fruitStorage.getFruits()
                .forEach((fruit, quantity) -> report.append(fruit)
                        .append(", ")
                        .append(quantity)
                        .append("\n"));
        return report.toString();
    }
}
