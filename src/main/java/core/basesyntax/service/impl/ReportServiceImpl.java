package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String FRUIT = "fruit";
    private static final String COMMA = ",";
    private static final String QUANTITY = "quantity";

    @Override
    public String createReport(List<Fruit> fruits) {
        StringBuilder builder = new StringBuilder();
        builder.append(FRUIT).append(COMMA).append(QUANTITY).append(System.lineSeparator());
        for (Fruit fruit : fruits) {
            builder.append(fruit.getName()).append(COMMA)
                    .append(fruit.getQuantity()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
