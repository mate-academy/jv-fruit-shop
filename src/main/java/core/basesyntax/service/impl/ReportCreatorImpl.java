package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(HEADER);
        FruitStorage.fruits.forEach((fruit, quantity) -> {
            builder.append(System.lineSeparator());
            builder.append(fruit);
            builder.append(",");
            builder.append(quantity);
        });
        return builder.toString();
    }
}
