package core.basesyntax.service.impl;

import core.basesyntax.service.Report;
import core.basesyntax.storage.Storage;

public class ReportImpl implements Report {
    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("Fruit, quantity")
                .append(System.lineSeparator());
        Storage.fruitStorage.forEach((key, value) -> builder.append(key)
                .append(",")
                .append(value)
                .append(System.lineSeparator()));
        return builder.toString();
    }
}
