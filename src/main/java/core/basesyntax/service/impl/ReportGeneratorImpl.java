package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String DELIMITER = ",";
    private static final String REPORT_HEADER = "fruit,quantity";
    private final FruitStorage fruitStorage;

    public ReportGeneratorImpl(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder(REPORT_HEADER);
        List<Fruit> fruits = fruitStorage.getFruits();

        for (Fruit fruit: fruits) {
            reportBuilder.append(System.lineSeparator())
                    .append(fruit.getName())
                    .append(DELIMITER)
                    .append(fruit.getQuantity());
        }

        return reportBuilder.toString();
    }
}
