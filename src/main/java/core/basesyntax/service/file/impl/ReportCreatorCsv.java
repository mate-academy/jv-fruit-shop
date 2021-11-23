package core.basesyntax.service.file.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.file.ReportCreator;

public class ReportCreatorCsv implements ReportCreator {
    private static final String FIRST_LINE = "fruit,quantity" + System.lineSeparator();

    @Override
    public String createReport() {
        StringBuilder result = new StringBuilder(FIRST_LINE);
        for (Fruit fruit : Storage.storage) {
            result.append(fruit.toString()).append(System.lineSeparator());
        }
        return result.toString();
    }
}
