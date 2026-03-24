package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String generate(Storage storage) {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity\n");
        storage.getStorage().forEach((fruit, quantity) -> stringBuilder.append(fruit)
                .append(",").append(quantity).append("\n"));
        return stringBuilder.toString();
    }
}
