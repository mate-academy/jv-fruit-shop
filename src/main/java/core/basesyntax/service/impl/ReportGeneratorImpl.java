package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMA = ",";
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder(HEADER + System.lineSeparator());
        Map<String,Integer> data = storage.getAll();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            builder.append(entry.getKey())
                    .append(COMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
