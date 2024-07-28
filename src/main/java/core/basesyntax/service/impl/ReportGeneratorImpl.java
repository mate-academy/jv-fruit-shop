package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport(Storage storage) {
        StringBuilder builder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.getStorage().entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException("Quantity can't be less than 0");
            }
            builder.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
