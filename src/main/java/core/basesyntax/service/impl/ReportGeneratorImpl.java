package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    private final Map<String, Integer> storage;

    public ReportGeneratorImpl(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("fruit,quantity\n");

        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            sb.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }

        return sb.toString();
    }
}
