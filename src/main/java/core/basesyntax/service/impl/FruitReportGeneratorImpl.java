package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import java.util.List;

public class FruitReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER_FRUIT = "fruit";
    private static final String HEADER_QUANTITY = "quantity";
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String generateReport(List<Fruit> fruits) {
        StringBuilder builder = new StringBuilder();
        builder.append(HEADER_FRUIT)
                .append(CSV_SEPARATOR)
                .append(HEADER_QUANTITY)
                .append(System.lineSeparator());
        for (Fruit fruit : fruits) {
            builder.append(fruit.getFruitName())
                    .append(CSV_SEPARATOR)
                    .append(fruit.getQuantity())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
