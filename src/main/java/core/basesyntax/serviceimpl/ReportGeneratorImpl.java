package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        if (storage == null) {
            throw new IllegalArgumentException("Storage can't be null");
        }
        this.storage = storage;
    }

    @Override
    public String getReport() {
        Map<String, Integer> allData = storage.getAll();
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : allData.entrySet()) {
            builder.append(entry.getKey()).append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
