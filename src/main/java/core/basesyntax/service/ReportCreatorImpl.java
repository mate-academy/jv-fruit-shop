package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public class ReportCreatorImpl implements ReportCreator {
    private static final String FRUIT_WORD = "fruit,quantity";

    @Override
    public String createReport(List<Fruit> fruits) {
        StringBuilder builder = new StringBuilder();
        builder.append(FRUIT_WORD)
                .append(System.lineSeparator());
        for (Fruit fruit : fruits) {
            builder.append(fruit.getName())
                    .append(",")
                    .append(fruit.getQuantity())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
