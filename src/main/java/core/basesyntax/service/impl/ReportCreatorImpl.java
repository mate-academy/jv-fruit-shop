package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import core.basesyntax.storage.Storage;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit, quantity");
        Storage.fruitStorage.forEach((key, value) -> builder.append(System.lineSeparator())
                .append(key)
                .append(",")
                .append(value));
        return builder.toString();
    }
}
