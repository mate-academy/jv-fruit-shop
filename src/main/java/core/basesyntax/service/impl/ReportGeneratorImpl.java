package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder("fruit,quantity");
        Storage.fruits.forEach((key, value) -> {
            sb.append(System.lineSeparator())
                    .append(key)
                    .append(",")
                    .append(value);

        });

        return sb.toString();
    }
}
