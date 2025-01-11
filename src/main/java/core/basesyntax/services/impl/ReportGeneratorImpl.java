package core.basesyntax.services.impl;

import core.basesyntax.services.ReportGenerator;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    private Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder str = new StringBuilder();
        str.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> map : storage.getStorage().entrySet()) {
            str.append(map.getKey()).append(COMMA)
                    .append(map.getValue()).append(System.lineSeparator());
        }
        return str.toString();
    }
}
